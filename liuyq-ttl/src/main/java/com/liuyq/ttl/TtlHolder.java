package com.liuyq.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author liuyuqing
 * @className TtlHolder
 * @description
 * @date 2021/7/7 10:10 上午
 */
public class TtlHolder {
    private static ThreadLocal<Integer> k1 = new TransmittableThreadLocal<>();
    private static ThreadLocal<Integer> k2 = new TransmittableThreadLocal<>();
    private static ThreadLocal<Integer> k3 = new TransmittableThreadLocal<>();


    public static Integer getK1() {
        return k1.get();
    }

    public static void setK1(Integer valueK1) {
        k1.set(valueK1);
    }

    public static Integer getK2() {
        return k2.get();
    }

    public static void setK2(Integer valueK2) {
        k2.set(valueK2);
    }

    public static Integer getK3() {
        return k3.get();
    }

    public static void setK3(Integer valueK3) {
        k3.set(valueK3);
    }
}
