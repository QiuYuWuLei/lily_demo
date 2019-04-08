package com.lily.demo.util;

import com.lily.demo.config.RedisConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisUtil {
    private static RedisConfiguration jmsConfig = RedisConfiguration.getInstance();

    public static RedisTemplate<String,Object> getRedisTemplate(){
        return jmsConfig.getRedisTemplate();
    }

    public static RedisTemplate<String,Object> getRedisTemplate(int dbIndex){
        return jmsConfig.getRedisTemplate(dbIndex);
    }

    public static RedisTemplate<String,Object> getRedisTemplate(String appName,int dbIndex){
        return jmsConfig.getRedisTemplate(appName,dbIndex);
    }

    public static RedisTemplate<String,Object> getRedisTemplate(String appName,int dbIndex,RedisSerializer<?> valueSerializer){
        return jmsConfig.getRedisTemplate(appName,dbIndex,new StringRedisSerializer(),valueSerializer);
    }

    public static RedisTemplate<String,Object> getRedisTemplate(int dbIndex,RedisSerializer<?> valueSerializer){
        return jmsConfig.getRedisTemplate(dbIndex,new StringRedisSerializer(),valueSerializer);
    }

    public static RedisTemplate<String,Object> getRedisTemplate(String appName,int dbIndex,RedisSerializer<?> keySerializer,RedisSerializer<?> valueSerializer){
        return jmsConfig.getRedisTemplate(appName,dbIndex,keySerializer,valueSerializer);
    }

    public static RedisTemplate<String,Object> getRedisTemplate(int dbIndex,RedisSerializer<?> keySerializer,RedisSerializer<?> valueSerializer){
        return jmsConfig.getRedisTemplate(dbIndex,keySerializer,valueSerializer);
    }

    public static RedisTemplate<String,Object> getStringRedisTemplate(int dbIndex){
        return jmsConfig.getStringRedisTemplate(dbIndex);
    }

    public static RedisTemplate<String,Object> getLongRedisTemplate(int dbIndex){
        return jmsConfig.getLongRedisTemplate(dbIndex);
    }
}
