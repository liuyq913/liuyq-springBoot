package com.liuyq.boot.serviceA;

/**
 * Created by liuyq on 2019/5/13.
 */

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.liuyq")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liuyq")
@MapperScan(basePackages = "com.liuyq.**.mapper")
@EnableCircuitBreaker //断路器
@EnableDistributedTransaction  //分布式事物tc
public class ProviderApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ProviderApplication.class, agrs);
    }

}
