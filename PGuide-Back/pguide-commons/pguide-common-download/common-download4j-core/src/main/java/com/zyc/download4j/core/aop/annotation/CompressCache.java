package com.zyc.download4j.core.aop.annotation;

import com.zyc.download4j.core.compress.Compression;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 和 {@link Download} 组合使用，
 * 可以单独配置 {@link Compression} 的缓存。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CompressCache {

    boolean enabled() default true;

    String group() default "";

    String name() default "";

    boolean delete() default false;
}
