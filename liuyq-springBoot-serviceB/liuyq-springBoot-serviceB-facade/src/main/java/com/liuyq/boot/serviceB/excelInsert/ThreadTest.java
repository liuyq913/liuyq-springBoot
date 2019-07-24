package com.liuyq.boot.serviceB.excelInsert;

import com.liuyq.boot.serviceB.bo.DemoBo;

import java.util.Date;
import java.util.List;

/**
 * Created by liuyq on 2019/7/24.
 */
public class ThreadTest extends Thread {

    private List list;


    public ThreadTest(List list) {
        this.list = list;
    }

    public void run() {
        while(list.size() < 1000) {
            DemoBo bo = new DemoBo();
            bo.setApp_name("liuyq");
            bo.setGroup_id("123");
            bo.setCreate_time(new Date());
            bo.setDemo_field("yaol");
            list.add(bo);
            System.out.println(Thread.currentThread().getName()+"insert bo 当前list是"+list.size());
        }
    }
}
