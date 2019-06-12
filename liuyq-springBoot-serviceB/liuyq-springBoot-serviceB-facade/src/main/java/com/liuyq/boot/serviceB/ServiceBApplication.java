package com.liuyq.boot.serviceB;

/**
 * Created by liuyq on 2019/5/13.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.liuyq")
@MapperScan(basePackages = "com.liuyq.boot.serviceB.mapper")
public class ServiceBApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ServiceBApplication.class, agrs);
    }

}
