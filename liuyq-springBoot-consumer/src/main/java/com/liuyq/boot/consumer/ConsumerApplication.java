package com.liuyq.boot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuyq on 2019/5/13.
 */
@SpringBootApplication
@EnableDiscoveryClient //让该应用成为Eureka的客户端，让他具备发现服务的能力
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients   //开启feign功能 （服务间调用）
@EnableCircuitBreaker //开启断路器功能
public class ConsumerApplication {


    @Bean
    @LoadBalanced //开启客户端负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] agrs){
        SpringApplication.run(ConsumerApplication.class);
    }
}
