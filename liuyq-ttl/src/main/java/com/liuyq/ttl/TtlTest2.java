package com.liuyq.ttl;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuyuqing
 * @className TtlTest2
 * @description
 * @date 2021/7/7 11:18 下午
 */
public class TtlTest2 {
    private static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws InterruptedException {
        TtlHolder.setK1(1);

        executorService.execute(() -> {
            try {
                TtlHolder.setK1(22);
                Thread.sleep(100L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread.sleep(1000L);
        System.out.println("主线程尝试抓取k2的值：" + TtlHolder.getK1());
        /* TtlHolder.setK2(2);//较第一次换下位置，换到第一次使用线程池后执行（这意味着下面这次异步不会再触发Thread的init方法了）

        System.out.println("---------------------------------------------------------------------------------");
        executorService.execute(() -> {
            try {
                System.out.println("尝试抓取k2的值：" + TtlHolder.getK2());
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/
    }
}
