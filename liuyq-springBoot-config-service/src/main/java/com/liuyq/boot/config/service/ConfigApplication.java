package com.liuyq.boot.config.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by liuyq on 2019/5/15.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer //开启configService
@EnableDiscoveryClient
public class ConfigApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ConfigApplication.class);
    }
}
