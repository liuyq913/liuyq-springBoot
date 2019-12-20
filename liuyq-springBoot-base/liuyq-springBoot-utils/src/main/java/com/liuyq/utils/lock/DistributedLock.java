package com.liuyq.utils.lock;


/**
 * @Auther: liuyuqing
 * @Date: 2019-12-20 11:30
 * @Description: 分布式锁模版
 */
public interface DistributedLock {

    /**
     * 分布获取锁
     * @return
     */
    boolean tryLock(String key);

    /**
     * 获取锁
     * @param key
     * @param time 失效时间
     * @return
     */
    boolean tryLock(String key , int time);

    /**
     * 释放锁
     * @param key
     * @return
     */
    boolean unLock(String key);

    /**
     * 在时间范围内轮寻获取锁
     * @param key
     * @param time
     * @return
     */
    boolean tryLockInTime(String key, int time);
}
