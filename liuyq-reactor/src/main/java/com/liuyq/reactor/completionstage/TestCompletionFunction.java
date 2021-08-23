package com.liuyq.reactor.completionstage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liuyuqing
 * @className TestCompletionFunction
 * @description
 * @date 2021/8/20 2:27 下午
 */
public class TestCompletionFunction {


    // 同步调用
    static void completedFutureExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    static void completedFutureExample_apply() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(t -> {
            return "haha";
        });
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    // 异步执行
    static void runAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            Thread thread = Thread.currentThread();
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程是否是守护线程：" + thread.isDaemon());
        });
        System.out.println("是否执行完" + cf.isDone());
        if (!cf.isDone()) {
            for (; ; ) {
                if (cf.isDone()) {
                    break;
                }
            }
        }
        System.out.println(cf.get());
    }

    public static void main(String[] ahrs) throws Exception {
        // completedFutureExample();

        runAsyncExample();

//        completedFutureExample_apply();
    }
}
