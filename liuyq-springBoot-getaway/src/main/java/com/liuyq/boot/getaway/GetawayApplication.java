package com.liuyq.boot.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liuyuqing
 * @className GetawayApplictaion
 * @description
 * @date 2021/7/8 2:08 下午
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GetawayApplication {

    public static void main(String[] args){
        SpringApplication.run(GetawayApplication.class, args);
    }
}
