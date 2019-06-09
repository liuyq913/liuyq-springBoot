package com.liuyq.boot.service.Task;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liuyq on 2019/5/26.
 */
public class MyTask extends TimerTask {
    private ThreadPoolExecutor executor;
    private final ScheduledExecutorService scheduler;
    private Runnable task;


    public MyTask(ThreadPoolExecutor executor, ScheduledExecutorService scheduler, Runnable task) {
        this.executor = executor;
        this.scheduler = scheduler;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            executor.execute(task);
            executor.execute(task);
          //  System.out.println("是否完成任务1：-----"+future.isDone());
           // System.out.println("是否完成任务2：-----"+future2.isDone());
            System.out.println("要关闭任务了");
            //shutdownNow 是通过中断来实现不执行任务的，这种方法的作用有限，如果线程中没有sleep 、wait、Condition、定时锁等应用,
            // interrupt()方法是无法中断当前的线程的 ，showdownNow并不代表线程池就立即退出。
            //List<Runnable> list =  executor.shutdownNow();
           // System.out.println("关闭线程池之前，未开始执行的任务大小---"+list.size());
            System.out.println("关闭了-----"+executor.isShutdown());
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
