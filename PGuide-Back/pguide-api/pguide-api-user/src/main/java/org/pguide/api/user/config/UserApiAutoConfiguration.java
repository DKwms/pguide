package org.pguide.api.user.config;

import org.pguide.common.redis.config.PguideRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2024/1/30 14:40
 * @description
 */
@Configuration
@ComponentScan({
        "org.pguide.api.user.redis",
        "org.pguide.user"
})
@AutoConfigureAfter(PguideRedisAutoConfiguration.class)
public class UserApiAutoConfiguration {
}
