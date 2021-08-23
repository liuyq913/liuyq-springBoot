package com.liuyq.ttl;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuyuqing
 * @className TtlTest
 * @description
 * @date 2021/7/5 4:49 下午
 */
public class TtlTest {
    // 这里需要通过TtlExecutors.getTtlExecutorService 包裹
    private static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws Exception {
        System.out.println("----主线程启动");
        TtlHolder.setK1(1);
        TtlHolder.setK2(2);


        executorService.submit(() -> {
            Integer k1 = TtlHolder.getK1();
            Integer k2 = TtlHolder.getK2();

            System.out.println("子线程：" + Thread.currentThread().getName() + "读取到k1：" + k1);
            System.out.println("子线程：" + Thread.currentThread().getName() + "读取到k2：" + k2);

            TtlHolder.setK3(33);
            System.out.println("子线程：" + Thread.currentThread().getName() + "设置k3：33");

        });


        Thread.sleep(1000);

        executorService.submit(() -> {
            Integer k3 = TtlHolder.getK3();
            System.out.println("子线程：" + Thread.currentThread().getName() + "读取到k3：" + k3);

        });

        System.out.println("主线程读：k3" + TtlHolder.getK3());

    }
}
