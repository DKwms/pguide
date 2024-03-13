package com.zyc.download4j.core.aop.annotation;

import java.lang.annotation.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载注解。
 * 标注了该注解的方法将被拦截。
 * 因为该注解将替换返回值，
 * 所以请标注在 Controller 的 Mapping 方法上。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Download {

    String[] source() default {};

    boolean inline() default false;

    String filename() default "";

    String contentType() default "";

    String compressFormat() default "";

    boolean forceCompress() default false;

    String charset() default "";

    String[] headers() default {};

    String extra() default "";
}
