package org.pguide.common.redis.config;

import org.pguide.common.redis.service.RedisService;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author DKwms
 * @Date 2023/9/19 18:05
 * @description
 */

/**
 * 出现了一个bug，在gateway模块使用的时候，会报错，但是在auth模块使用的时候没有问题<br>
 * 可能是加载顺序的问题，只要这个配置类比原本的redistemplate先加载出来就行，gateway里面的应该是反了顺序<br>
 * 这里的解决方案智能写下面的这个配置让类尽可能的优先加载生效，覆盖掉原来的redisTemplate
 */
@AutoConfigureBefore(RedisAutoConfiguration.class)
// scan the path
//@ComponentScan("org.pguide.common.redis")
// use when project is a web App
//@ConditionalOnWebApplication
@Configuration
@EnableCaching
// 这里是自定义redistemplate的关键
public class PguideRedisAutoConfiguration extends CachingConfigurerSupport {

    @Bean
    public RedisService redisService(){
        return new RedisService();
    }

    @Bean
    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory)
    {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }

}
