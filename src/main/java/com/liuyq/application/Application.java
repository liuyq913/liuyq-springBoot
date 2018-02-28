package com.liuyq.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2017-10-15.
 */
@ComponentScan  //SpringBoot在写启动类的时候如果不使用@ComponentScan指明对象扫描范围，默认指扫描当前启动类所在的包里的对象
@EnableAutoConfiguration   //  启动自动配置
public class Application {
    public static void main(String[] agrs){
        SpringApplication.run(Application.class, agrs); //运行
    }
}
