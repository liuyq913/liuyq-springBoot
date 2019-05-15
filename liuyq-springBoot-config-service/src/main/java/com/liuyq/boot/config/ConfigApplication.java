package com.liuyq.boot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by liuyq on 2019/5/15.
 */
@SpringBootApplication
@EnableConfigServer //开启configService
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ConfigApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ConfigApplication.class);
    }
}
