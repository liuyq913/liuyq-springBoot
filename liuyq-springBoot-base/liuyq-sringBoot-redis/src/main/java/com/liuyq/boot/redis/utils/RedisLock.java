package com.liuyq.boot.redis.utils;

import com.liuyq.utils.lock.DistributedLock;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-20 11:43
 * @Description:
 */
@Slf4j
public class RedisLock implements DistributedLock {

    private RedisClustorUtil redisClustorUtil;
    private static final String OK = "OK";

    @Override
    public boolean tryLock(String key) {
        return tryLockInTime(key, 0);
    }

    @Override
    public boolean tryLock(String key, int time) {
        try {
            return OK.equals(redisClustorUtil.setex(key, key, time));
        } catch (Exception e) {
            log.error("key:" + key + "tryLock error, message:" + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean unLock(String key) {
        Long reply = 0l;
        try {
            return redisClustorUtil.decr(key).equals(1l);
        } catch (Exception e) {
            log.error("key:" + key + "unlock error, message:" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean tryLockInTime(String key, int time) {
        Boolean reply = Boolean.FALSE;
        //当前时间
        long nano = System.nanoTime();
        try {
            do {
                reply = redisClustorUtil.setnx(key, key).equals(1l);
                if (reply) {
                    return reply;  //获取到锁直接返回
                } else {
                    log.info("key:" + key + "exit,try again!!!!");
                }
                if (time <= 0) break;  //没有设置超时时间，也不进行轮训
                Thread.sleep(300); //稍微等一下
            } while (System.nanoTime() - nano < TimeUnit.MILLISECONDS.toNanos(time));
        } catch (Exception e) {
            log.error("key:" + key + "tryLockInTime error, message:" + e.getMessage());
        }
        return reply;
    }

    public void setRedisClustorUtil(RedisClustorUtil redisClustorUtil) {
        this.redisClustorUtil = redisClustorUtil;
    }
}
