package com.zyc.download4j.core.aop.annotation;

import com.zyc.download4j.core.source.Source;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 和 {@link Download} 组合使用，
 * 可以单独配置 {@link Source} 的缓存。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SourceCache {

    boolean enabled() default true;

    String group() default "";

    boolean delete() default false;
}
