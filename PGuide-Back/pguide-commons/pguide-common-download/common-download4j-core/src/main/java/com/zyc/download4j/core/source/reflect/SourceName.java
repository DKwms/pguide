package com.zyc.download4j.core.source.reflect;

import com.zyc.download4j.core.source.Source;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 标记一个字段或方法作为 {@link Source} 名称的值。
 *
 * @see Source#getName()
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SourceReflection(methodName = "setName", methodParameterType = String.class, fieldName = "name")
public @interface SourceName {

}
