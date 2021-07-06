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
    private static ThreadLocal<String> inheritableThreadLocal = new TransmittableThreadLocal<>();
    // 这里需要通过TtlExecutors.getTtlExecutorService 包裹
    private static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws Exception{
        System.out.println("----主线程启动");
        inheritableThreadLocal.set("主线程第一次赋值");
        System.out.println("----主线程设置后获取值：" + inheritableThreadLocal.get());
        executorService.submit(new TtlTest());
        System.out.println("主线程休眠2秒");
        Thread.sleep(2000);
        inheritableThreadLocal.set("主线程第二次赋值");
        executorService.submit(new TtlTest());
        executorService.shutdown();
    }

    @Override
    public void run() {
        System.out.println("----子线程获取值：" + inheritableThreadLocal.get());
    }
}
