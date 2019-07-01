package com.liuyq.boot.redis.utils;

/**
 * Created by liuyq on 2019/6/28.
 */
@FunctionalInterface
public interface RedisFuntion <T> {
    T get();
}
