package com.liuyq.rxjava.pub_sub_app;

/**
 * @author liuyuqing
 * @className Temperature
 * @description
 * @date 2021/8/21 1:56 下午
 */
public final class Temperature {
    private final double value;

    public Temperature(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
