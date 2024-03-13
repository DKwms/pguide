package com.zyc.download4j.core.source.reflect.conversion;

import com.zyc.download4j.core.exception.DownloadException;

import java.lang.reflect.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 值转换器。
 */
public interface ValueConvertor<S, T> {

    T convert(S value);

    default boolean support(Object value, Class<?> type) {
        ParameterizedType pt = find(getClass());
        if (pt == null) {
            throw new DownloadException("Cannot happen ???");
        }
        Type[] types = pt.getActualTypeArguments();
        Class<?> fromClass = toClass(types[0]);
        if (fromClass == null) {
            return false;
        }
        if (!fromClass.isInstance(value)) {
            return false;
        }
        Class<?> toClass = toClass(types[1]);
        if (toClass == null) {
            return false;
        }
        if (!type.isAssignableFrom(toClass)) {
            return false;
        }
        return true;
    }

    static Class<?> toClass(Type type) {
        if (type instanceof Class) {
            return (Class<?>) type;
        }
        if (type instanceof ParameterizedType) {
            return toClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof WildcardType || type instanceof TypeVariable || type instanceof GenericArrayType) {
            //能拿到泛型，但是没有具体类型
            //需要其他泛型类配合输出
        }
        return null;
    }

    static ParameterizedType find(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        Type[] interfaces = clazz.getGenericInterfaces();
        for (Type i : interfaces) {
            if (i instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) i;
                if (pt.getRawType() == ValueConvertor.class) {
                    return pt;
                }
            }
        }
        return find(clazz.getSuperclass());
    }
}
