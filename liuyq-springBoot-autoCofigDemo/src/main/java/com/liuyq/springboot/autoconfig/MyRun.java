package com.liuyq.springboot.autoconfig;

import com.liuyq.boot.redis.utils.RedisClustorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuyq on 2019/5/10.
 */
@SpringBootApplication(scanBasePackages = "com.liuyq",exclude = {DataSourceAutoConfiguration.class})
@RestController
public class MyRun {
    @Autowired
    private HelloService helloService;
    @Resource
    private RedisClustorUtil redisClustorUtil;

    @RequestMapping("/auto/home")
    public String home(){
        return helloService.say();
    }
    @RequestMapping("/clustor/redis")
    public String testRedis(){
        redisClustorUtil.set("liuyq","1993");
       return redisClustorUtil.getObject("liuyq", String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyRun.class,args);
    }
}
