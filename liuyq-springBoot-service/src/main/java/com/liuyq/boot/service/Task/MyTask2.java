package com.liuyq.boot.service.Task;

/**
 * Created by liuyq on 2019/5/26.
 */
public class MyTask2 implements Runnable{
    @Override
    public void run() {
        System.out.println("执行任务开始。。。");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束。。。");
    }
}
