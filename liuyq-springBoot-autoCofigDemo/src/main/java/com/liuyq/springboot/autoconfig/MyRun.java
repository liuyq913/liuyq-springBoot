package com.liuyq.springboot.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyq on 2019/5/10.
 */
@SpringBootApplication(scanBasePackages = "com.liuyq.springboot.autoconfig")
@RestController
public class MyRun {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/auto/home")
    public String home(){
        return helloService.say();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyRun.class,args);
    }
}
