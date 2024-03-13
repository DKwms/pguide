package org.pguide.common.redis.annotations;

import org.pguide.common.redis.service.RedisService;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author DKwms
 * @date 2023/9/19 18:13
 * @description
 */


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RedisService.class)
public @interface LoadRedis {
}
