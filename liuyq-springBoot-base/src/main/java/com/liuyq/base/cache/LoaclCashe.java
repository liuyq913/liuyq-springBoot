package com.liuyq.base.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyq on 2019/6/13.
 * 本地存储
 */
public class LoaclCashe extends Cashe {

    private static final Map<Object, ExpireCache> localCashe = new ConcurrentHashMap<>();

    /**
     * 该存储器存储的值大小
     */
    private static final AtomicInteger size = new AtomicInteger(0);

    @Override
    public <K, V> V push(K key, V value) {
        return null;
    }

    @Override
    public <K, V> V push(K key, V vlaue, long outTime) {
        return null;
    }

    @Override
    public Integer size() {
        return null;
    }

    @Override
    public <K, V> void clear(K key) {

    }

    @Override
    public void clearAll() {

    }

    /**
     * 本地缓存的对象规范
     */
    static class ExpireCache {
        /**
         * 实际存储值
         */
        private Object value;
        /**
         * 还有多久到期
         */
        private Long rexpireTime;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Long getRexpireTime() {
            return rexpireTime - System.currentTimeMillis();
        }

        public void setRexpireTime(Long rexpireTime) {
            this.rexpireTime = rexpireTime;
        }
    }
}
