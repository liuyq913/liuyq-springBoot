package com.liuyq.boot.zuul;


import com.liuyq.boot.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by liuyq on 2019/5/15.
 */
@EnableZuulProxy //开启Zuul
@SpringBootApplication(scanBasePackages = "com.liuyq")
//@springCloudApplication 是@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker  的整合
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ZuulApplication {


    public static void main(String[] agrs) {
        SpringApplication.run(ZuulApplication.class);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
