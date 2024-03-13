package org.pguide.common.page.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author DKwms
 * @Date 2024/2/6 15:07
 * @description 自动分页注解，配合pagehelper来进行分页
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EasyPage {

    @AliasFor("pageMaxSize")
    int value() default -1;

    /**
     * 分页大小<br>
     * 需要更改，也可以使用注解的参数，这里的优先级最高，会覆盖掉所有的其他配置
     */
    @AliasFor("value")
    int pageMaxSize() default -1;

    /**
     * 最大分页深度<br>
     *
     * @return
     */
    int pageMaxNum() default -1;

    /**
     * 排序顺序，<br>
     * true是默认顺序（升序）
     */
    boolean pageOrder() default true;
}
