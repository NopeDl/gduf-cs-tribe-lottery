package com.bigliang.draw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/9 21:15
 */

@EnableCaching
@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private int max_wait;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int max_active;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int max_idle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int min_idle;

    @Value("${spring.redis.timeout}")
    private int timeout;

    /**
     * 配置redis连接池
     * @return 返回一个redis连接池
     */
    @Bean
    public JedisPool redisconfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(max_idle);
        jedisPoolConfig.setMinIdle(min_idle);
        jedisPoolConfig.setMaxWaitMillis(max_wait);
        jedisPoolConfig.setMaxTotal(max_active);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        return new JedisPool(jedisPoolConfig, host, port, timeout);
    }

}
