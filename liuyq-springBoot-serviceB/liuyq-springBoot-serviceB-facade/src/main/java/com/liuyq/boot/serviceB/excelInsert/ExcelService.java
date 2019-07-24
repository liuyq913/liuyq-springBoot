package com.liuyq.boot.serviceB.excelInsert;

import com.google.common.collect.Lists;
import com.liuyq.boot.serviceB.bo.DemoBo;
import com.liuyq.boot.serviceB.domain.ServiceBNativeDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by liuyq on 2019/7/24.
 */
@Service
public class ExcelService{

    private volatile List<DemoBo> list = Lists.newArrayList();

    public void ExcelInsert() throws InterruptedException {
        for(int i = 0;i<4 ;i++){
            ThreadTest threadTest = new ThreadTest(list);
            threadTest.setName("thread"+i);
            threadTest.start();
        }
        do {
            Thread.sleep(1000);
        }while (list.size() < 1000);
        System.out.println("list.size："+list.size());
        InsertTask task = new InsertTask(list, ServiceBNativeDomain.class);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task); //执行insert
    }
}
