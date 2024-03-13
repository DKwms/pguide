package com.zyc.download4j.core.source.reflect;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 标记一个类作为反射的数据模型。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SourceReflection
public @interface SourceModel {

    boolean superclass() default true;
}
