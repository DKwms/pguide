package com.zyc.download4j.core.source.reflect;

import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.reflect.conversion.ValueConversion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 每个类对应一个反射模版，包含该类的反射信息。
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReflectionTemplate {

    protected final Map<Class<? extends Annotation>, Reflector> reflectorMap = new HashMap<>();

    public ReflectionTemplate(Class<?> clazz) {
        this(clazz, isReflectSuper(clazz));
    }

    public ReflectionTemplate(Class<?> clazz, boolean reflectSuper) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();

                if (annotationType.isAnnotationPresent(SourceReflection.class)) {
                    int count = method.getParameterCount();
                    if (count == 0) {
                        Reflector exist = reflectorMap.get(annotationType);
                        if (exist == null) {
                            reflectorMap.put(annotationType, new MethodReflector(method));
                        } else {
                            throw new DownloadException(annotationType.getName()
                                    + " is already defined on " + exist);
                        }
                    } else {
                        throw new DownloadException("Method cannot have parameters: " + method);
                    }
                }
            }
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();

                if (annotationType.isAnnotationPresent(SourceReflection.class)) {
                    Reflector exist = reflectorMap.get(annotationType);
                    if (exist == null) {
                        reflectorMap.put(annotationType, new FieldReflector(field));
                    } else {
                        throw new DownloadException(annotationType.getName()
                                + " is already defined on " + exist);
                    }
                }
            }
        }

        //Handle Parent Classes
        if (reflectSuper) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                ReflectionTemplate template = new ReflectionTemplate(superclass, true);
                mergeSuper(template);
            }
        }
    }

    @Deprecated
    public static boolean hasAnnotation(Class<? extends Annotation> annotation) {
        if (annotation == SourceReflection.class) {
            return true;
        }
        Annotation[] annotations = annotation.getAnnotations();
        for (Annotation a : annotations) {
            boolean hasAnnotation = hasAnnotation(a.annotationType());
            if (hasAnnotation) {
                return true;
            }
        }
        return false;
    }

    public static boolean isReflectSuper(Class<?> clazz) {
        SourceModel annotation = clazz.getAnnotation(SourceModel.class);
        if (annotation == null) {
            throw new DownloadException("@SourceModel not found");
        }
        return annotation.superclass();
    }

    public Object value(Class<? extends Annotation> annotation, Object model) {
        return reflectorMap.get(annotation).reflect(model);
    }

    @SneakyThrows
    public void reflect(Object model, Source source) {
        for (Map.Entry<Class<? extends Annotation>, Reflector> entry : reflectorMap.entrySet()) {
            Object reflect = entry.getValue().reflect(model);
            /*if (reflect == null) {
                continue;
            }*/
            SourceReflection reflection = entry.getKey().getAnnotation(SourceReflection.class);
            //优先使用方法设置
            if (!reflectMethod(reflection, source, reflect)) {
                reflectField(reflection, source, reflect);
            }
        }
    }

    @SneakyThrows
    protected boolean reflectField(SourceReflection reflection, Source source, Object reflect) {
        String fieldName = reflection.fieldName();
        if (fieldName.isEmpty()) {
            return false;
        }
        Field field = getReflectField(source.getClass(), fieldName);
        if (field == null) {
            return false;
        }
        Class<?> type = field.getType();
        Object value;
        if (reflect == null || type.isInstance(reflect)) {
            value = reflect;
        } else {
            value = convertValue(reflect, type);
        }
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(source, value);
        return true;
    }

    @SneakyThrows
    protected boolean reflectMethod(SourceReflection reflection, Source source, Object reflect) {
        String methodName = reflection.methodName();
        if (methodName.isEmpty()) {
            return false;
        }
        Class<?> parameterType = reflection.methodParameterType();
        Method method = getReflectMethod(source.getClass(), methodName, parameterType);
        if (method == null) {
            return false;
        }
        Object value;
        if (reflect == null || parameterType.isInstance(reflect)) {
            value = reflect;
        } else {
            value = convertValue(reflect, parameterType);
        }
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        method.invoke(source, value);
        return true;
    }

    protected Field getReflectField(Class<?> clazz, String name) {
        Class<?> c = clazz;
        while (c != null) {
            try {
                return c.getDeclaredField(name);
            } catch (Throwable ignore) {
            }
            c = c.getSuperclass();
        }
        return null;
    }

    protected Method getReflectMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        Class<?> c = clazz;
        while (c != null) {
            try {
                return c.getDeclaredMethod(name, parameterTypes);
            } catch (Throwable ignore) {
            }
            c = c.getSuperclass();
        }
        return null;
    }

    protected Object convertValue(Object value, Class<?> type) {
        return ValueConversion.getInstance().convert(value, type);
    }

    protected void mergeSuper(ReflectionTemplate template) {
        for (Map.Entry<Class<? extends Annotation>, Reflector> entry : template.reflectorMap.entrySet()) {
            if (!reflectorMap.containsKey(entry.getKey())) {
                reflectorMap.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
