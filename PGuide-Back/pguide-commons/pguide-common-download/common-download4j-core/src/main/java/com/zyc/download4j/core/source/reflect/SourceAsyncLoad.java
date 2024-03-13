package com.zyc.download4j.core.source.reflect;

import com.zyc.download4j.core.source.Source;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 标记一个字段或方法作为是否异步加载的值。
 *
 * @see Source#isAsyncLoad()
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SourceReflection(methodName = "setAsyncLoad", methodParameterType = boolean.class, fieldName = "asyncLoad")
public @interface SourceAsyncLoad {

}
