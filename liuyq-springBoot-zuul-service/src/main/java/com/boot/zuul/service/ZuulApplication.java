package com.boot.zuul.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by liuyq on 2019/5/15.
 */
@EnableZuulProxy //开启Zuul
@SpringCloudApplication  //@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker  的整合
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ZuulApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ZuulApplication.class);
    }
}
