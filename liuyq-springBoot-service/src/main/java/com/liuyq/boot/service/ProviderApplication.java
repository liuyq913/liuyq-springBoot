package com.liuyq.boot.service;

/**
 * Created by liuyq on 2019/5/13.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ProviderApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ProviderApplication.class, agrs);
    }

}
