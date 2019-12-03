package com.liuyq.springboot.redis.cache.config;


import com.liuyq.boot.redis.config.RedisClusterConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Map;

@EnableCaching  //启动spring cashe
@Configuration
public class RedisCashConfig {


    @Resource
    private RedisClusterConfig redisClusterConfig;


    @Bean(name = "redisCacheConnectionFactory")
    public RedisConnectionFactory connectionCacheFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();

        //集群状态下
        Map<String, Integer> hostAndPort = redisClusterConfig.getHostAndPort();
        hostAndPort.forEach((k, v) -> {
            sentinelConfig.addSentinel(new RedisNode(k, v));
        });

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(sentinelConfig);
        connectionFactory.setUsePool(true);
        connectionFactory.setPoolConfig(redisClusterConfig.getJedisPoolConfig());
        return connectionFactory;
    }


    @Bean
    public RedisCacheManager redisCacheManager(@Qualifier("redisCacheConnectionFactory")
                                                           RedisConnectionFactory redisConnectionFactory) {

        return RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)))
                .transactionAware()
                .build();
    }


}
