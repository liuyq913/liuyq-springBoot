package com.liuyq.boot.service.Task;

import java.util.concurrent.*;

/**
 * Created by liuyq on 2019/5/26.
 */
public class Demo {
    public static void main(String[] agrs){

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        MyTask myTask = new MyTask(new ThreadPoolExecutor(2,3,1000, TimeUnit.SECONDS, new SynchronousQueue()), service, new MyTask2());
        service.schedule(myTask, 10, TimeUnit.SECONDS);
       // service.shutdownNow();
    }}
