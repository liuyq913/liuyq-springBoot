package com.liuyq.springboot.redis.cache;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
}, scanBasePackages = "com.liuyq")  //这了如果不配置，那么即使把基础包引用进来，也还是无法被扫描到

public class CacheApplication {
    public static void main(String[] agrs) {
        SpringApplication.run(CacheApplication.class);
    }
}
