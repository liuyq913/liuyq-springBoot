package com.liuyq.boot.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by liuyq on 2019/5/13.
 */
@SpringBootApplication
@EnableDiscoveryClient //让该应用成为Eureka的客户端，让他具备发现服务的能力
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
public class ConsumerApplication {
    public static void main(String[] agrs){
        SpringApplication.run(ConsumerApplication.class);
    }
}
