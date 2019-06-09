package com.liuyq.boot.service.Task;

/**
 * Created by liuyq on 2019/5/26.
 */
public class MyTask2 implements Runnable{
    @Override
    public void run() {
        System.out.println("执行任务开始。。。");
        try {
            Thread.sleep(1000);
           for(int i= 0;i<1000;i++){
               System.out.println(i);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行结束。。。");
    }
}
