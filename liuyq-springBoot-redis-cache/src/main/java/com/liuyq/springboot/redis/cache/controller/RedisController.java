package com.liuyq.springboot.redis.cache.controller;

import com.liuyq.boot.redis.utils.RedisClustorUtil;
import com.liuyq.boot.redis.utils.RedisLock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-19 22:22
 * @Description:
 */
@RestController
public class RedisController {

    @Resource
    private RedisClustorUtil redisClustorUtil;

    @Resource
    private RedisLock redisLock;


    @RequestMapping(value = "testRedis", method = RequestMethod.GET)
    public String testRedis(String key, String value) {
        redisClustorUtil.set(key, value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return redisClustorUtil.getObject(key, String.class);
    }


    @RequestMapping(value = "trylock", method = RequestMethod.POST)
    public Boolean tryLock(String key, Integer time) {
        return redisLock.tryLockInTime(key, time);
    }
}

