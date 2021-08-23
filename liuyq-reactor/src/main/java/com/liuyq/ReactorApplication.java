package com.liuyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author liuyuqing
 * @className com.liuyq.ReactorApplication
 * @description
 * @date 2021/7/9 3:02 下午
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ReactorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactorApplication.class, args);
    }
}
