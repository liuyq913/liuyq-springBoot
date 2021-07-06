package com.liuyq.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyuqing
 * @className TtlTestSimple
 * @description
 * @date 2021/7/5 5:11 下午
 */
public class TtlTestSimple {

    private static Executor executor = Executors.newFixedThreadPool(1);
    private static ThreadLocal<Integer> ttl = new TransmittableThreadLocal();
    private static AtomicInteger i = new AtomicInteger(0);
    private static ThreadLocal<Integer> itl = new InheritableThreadLocal();

    public static void main(String[] agrs) {
        itl.set(0);
        System.out.println(Thread.currentThread().getName() + "存放的值" + itl.get());
        executor.execute(() -> {
            itl.set(1);
            System.out.println(Thread.currentThread().getName() + "存放的值" + itl.get());
        });

        executor.execute(() -> {
            itl.set(2);
            System.out.println(Thread.currentThread().getName() + "存放的值" + itl.get());
        });


        executor.execute(() -> {
            itl.set(3);
            System.out.println(Thread.currentThread().getName() + "存放的值" + itl.get());
        });


        System.out.println(Thread.currentThread().getName() + "存放的值" + itl.get());
    }

}
