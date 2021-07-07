package com.liuyq.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuyuqing
 * @className TtlTest
 * @description
 * @date 2021/7/5 4:49 下午
 */
public class TtlTest implements Runnable {
    private static ThreadLocal<Integer> k1 = new TransmittableThreadLocal<>();
    private static ThreadLocal<Integer> k2 = new TransmittableThreadLocal<>();
    private static ThreadLocal<Integer> k3 = new TransmittableThreadLocal<>();
    // 这里需要通过TtlExecutors.getTtlExecutorService 包裹
    private static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws Exception {
        System.out.println("----主线程启动");
        k1.set(1);
        k2.set(2);
        System.out.println("----主线程设置后获取值：" + k1.get());
        executorService.submit(new TtlTest());


        System.out.println("----子线程");
        executorService.submit(new TtlTest());
    }

    @Override
    public void run() {
        k1.set(11);
        k3.set(33);
        System.out.println("----子线程获取值：" + k1.get());
    }
}
