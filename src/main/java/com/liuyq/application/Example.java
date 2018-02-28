package com.liuyq.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyq on 2017/12/22.
 */
@RestController  //为构造（stereotype）注解
@EnableAutoConfiguration //这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring
public class Example {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args); //以此告诉SpringApplication谁是主要的Spring组件
    }
}
