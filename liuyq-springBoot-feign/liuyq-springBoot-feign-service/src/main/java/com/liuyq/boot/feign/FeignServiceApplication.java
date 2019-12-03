package com.liuyq.boot.feign;

import com.liuyq.boot.feign.configuration.SpringBeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * Created by liuyq on 2019/5/14.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@Import(SpringBeanUtils.class)
public class FeignServiceApplication {
    public static void main(String[] agrs) {
        SpringApplication.run(FeignServiceApplication.class);
    }
}
