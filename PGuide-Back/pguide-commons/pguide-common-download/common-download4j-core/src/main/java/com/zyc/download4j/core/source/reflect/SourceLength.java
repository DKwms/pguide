package com.zyc.download4j.core.source.reflect;

import com.zyc.download4j.core.source.Source;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 标记一个字段或方法作为 {@link Source} 长度的值。
 *
 * @see Source#getLength()
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SourceReflection(methodName = "setLength", methodParameterType = Long.class, fieldName = "length")
public @interface SourceLength {

}
