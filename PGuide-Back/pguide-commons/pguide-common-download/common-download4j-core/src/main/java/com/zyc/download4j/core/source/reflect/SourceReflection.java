package com.zyc.download4j.core.source.reflect;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基础注解，方便扩展自定义注解。
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SourceReflection {

    String methodName() default "";

    Class<?> methodParameterType() default void.class;

    String fieldName() default "";
}
