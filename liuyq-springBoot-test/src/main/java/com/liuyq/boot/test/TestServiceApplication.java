package com.liuyq.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by liuyq on 2019/5/8.
 */
@SpringBootApplication
//springboot默认会注入DataSourceAutoConfiguration 因为工程里面没有dataSource的配置，这里过滤掉
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class TestServiceApplication {
    public static void main(String[] agrs) {
        SpringApplication.run(TestServiceApplication.class, agrs);
    }
}
