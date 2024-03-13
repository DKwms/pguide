package org.pguide.common.security.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author DKwms
 * @Date 2024/1/31 13:36
 * @description
 * 权限校验注解
 */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAuth {

    @AliasFor("authKey")
    String value() default "";

    /**
     * 权限关键字
     */
    @AliasFor("value")
    String authKey() default "";

}
