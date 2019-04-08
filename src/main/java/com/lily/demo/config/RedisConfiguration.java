package com.lily.demo.config;

import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.util.HashMap;
import java.util.Map;

public class RedisConfiguration {
    private RedisConfiguration() {
    }

    private static final RedisConfiguration rc = new RedisConfiguration();

    public static RedisConfiguration getInstance() {
        return rc;
    }

    private JedisConnectionFactory getCachingConnectionFactory(String appName, int dbIndex) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();

        //设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setPassword("lily123");
        redisStandaloneConfiguration.setDatabase(dbIndex);

        //获得默认的连接池构造
        //这里需要注意的是，edisConnectionFactoryJ对于Standalone模式的没有（RedisStandaloneConfiguration，JedisPoolConfig）的构造函数，对此
        //我们用JedisClientConfiguration接口的builder方法实例化一个构造器，还得类型转换
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();

        //修改我们的连接池配置
        jpcf.poolConfig(getJedisPoolConfig());

        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    private JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(200);
        config.setMaxIdle(50);
        //设置最小空闲数
        config.setMinIdle(8);
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        //Idle时进行连接扫描
        config.setTestWhileIdle(true);
        //表示idle object evitor两次扫描之间要sleep的毫秒数
        config.setTimeBetweenEvictionRunsMillis(30000);
        //表示idle object evitor每次扫描的最多的对象数
        config.setNumTestsPerEvictionRun(10);
        //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
        config.setMinEvictableIdleTimeMillis(60000);
        return config;
    }

    private Map<String, RedisTemplate<String, Object>> redisTemplates = new HashMap<String, RedisTemplate<String, Object>>();

    public RedisTemplate<String,Object> getRedisTemplate(){
        return getRedisTemplate(0);
    }

    public RedisTemplate<String, Object> getRedisTemplate(String test, int dbIndex, StringRedisSerializer stringRedisSerializer, JdkSerializationRedisSerializer jdkSerializationRedisSerializer) {
        return getRedisTemplate(0);
    }

    public RedisTemplate<String, Object> getRedisTemplate(int dbIndex) {
        return getRedisTemplate("test", dbIndex, new StringRedisSerializer(), new JdkSerializationRedisSerializer());
    }

    public RedisTemplate<String, Object> getRedisTemplate(String appName, int dbIndex) {
        return getRedisTemplate(appName, dbIndex, new StringRedisSerializer(), new JdkSerializationRedisSerializer());
    }

    public RedisTemplate<String, Object> getRedisTemplate(int dbIndex, RedisSerializer<?> keySerializer, RedisSerializer<?> valueSerializer) {
        return getRedisTemplate("test", dbIndex, keySerializer, valueSerializer);
    }

    public RedisTemplate<String, Object> getStringRedisTemplate(int dbIndex) {
        return getRedisTemplate("test", dbIndex, new StringRedisSerializer(), new StringRedisSerializer());
    }

    public RedisTemplate<String, Object> getLongRedisTemplate(int dbIndex) {
        return getRedisTemplate("test", dbIndex, new StringRedisSerializer(), new GenericToStringSerializer<Long>(Long.class));
    }

    public RedisTemplate<String, Object> getRedisTemplate(String appName, int dbIndex, RedisSerializer<?> keySerializer, RedisSerializer<?> valueSerializer) {
        String redisKey = String.format("%s_%s", appName, dbIndex);
        if (redisTemplates.get(redisKey) != null) {
            return redisTemplates.get(redisKey);
        }
        synchronized (this) {
            if (redisTemplates.get(redisKey) != null) {
                return redisTemplates.get(redisKey);
            }
            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
            redisTemplate.setConnectionFactory(getCachingConnectionFactory(appName, dbIndex));
            redisTemplate.setKeySerializer(keySerializer);
            redisTemplate.setValueSerializer(valueSerializer);
            redisTemplate.afterPropertiesSet();
            redisTemplates.put(redisKey, redisTemplate);
            return redisTemplate;
        }
    }
}
