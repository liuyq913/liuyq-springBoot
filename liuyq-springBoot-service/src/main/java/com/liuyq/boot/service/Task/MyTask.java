package com.liuyq.boot.service.Task;

import java.util.TimerTask;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liuyq on 2019/5/26.
 */
public class MyTask extends TimerTask{
    private ThreadPoolExecutor executor;
    private ScheduledExecutorService scheduler;
    private Runnable task;


    public MyTask(ThreadPoolExecutor executor, ScheduledExecutorService scheduler, Runnable task){
        this.executor = executor;
        this.scheduler = scheduler;
        this.task = task;
    }
    @Override
    public void run() {
        Future future =  executor.submit(task);
        try {
            System.out.println("mytask");
            scheduler.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
