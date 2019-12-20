package com.liuyq.springboot.redis.cache.config;

import com.liuyq.boot.redis.utils.RedisClustorUtil;
import com.liuyq.boot.redis.utils.RedisLock;
import com.liuyq.utils.lock.DistributedLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-20 14:29
 * @Description:
 */
@Configuration
public class RedisLockConfig {

    @Bean(value = "redisLock")
    public DistributedLock buildRedisLock(RedisClustorUtil redisClustorUtil) {
        RedisLock redisLock = new RedisLock();
        redisLock.setRedisClustorUtil(redisClustorUtil);
        return redisLock;
    }
}
