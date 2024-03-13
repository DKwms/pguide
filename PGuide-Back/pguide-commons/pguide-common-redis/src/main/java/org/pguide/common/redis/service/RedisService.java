package org.pguide.common.redis.service;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author DKwms
 * @Date 2023 09 2023/9/19 13 23
 *
 * 完善redis序列化问题
 */


public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 不设置缓存过期时长
     */
    public <T> void setObj(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 默认缓存时间单位为分钟
     */
    public <T> void setObj(String key, T value, Long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MINUTES);
    }

    /**
     * 自定义缓存过期时长
     */
    public <T> void setObj(String key, T value, Long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * get String
     */
    public String getString(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * get Obj<br>
     * 返回的是java对象
     */
    public Object getObj(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存中所有集合
     */
    public  <T> List<T> getList(String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 不用在使用类中反复注入，直接获取redisTemplate，
     * 少写一个自动注入
     */
    public RedisTemplate getRedisTemplate(){
        return redisTemplate;
    }

}
