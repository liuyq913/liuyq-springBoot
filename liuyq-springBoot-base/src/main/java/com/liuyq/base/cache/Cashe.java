package com.liuyq.base.cache;

/**
 * Created by liuyq on 2019/6/13.
 * 本地缓存类
 */
public abstract class Cashe {


    /**
     * 存储值
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     * @return
     */
    public abstract <K, V> V push(K key, V value);

    /**
     * 带超时时间 存储值  超时自动过期
     * @param key
     * @param vlaue
     * @param outTime
     * @param <K>
     * @param <V>
     * @return
     */
    public abstract <K,V> V push(K key, V vlaue, long outTime);


    /**
     * 存储值个数
     * @return
     */
    public abstract Integer size();

    /**
     * 删除指定key的缓存
     * @param key
     * @param <K>
     * @param <V>
     */
    public abstract <K,V> void clear(K key);

    /**
     * 清空所有
     */
    public abstract void clearAll();
}
