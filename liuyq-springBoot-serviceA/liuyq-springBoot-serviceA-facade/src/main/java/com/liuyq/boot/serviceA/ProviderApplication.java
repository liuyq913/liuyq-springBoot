package com.liuyq.boot.serviceA;

/**
 * Created by liuyq on 2019/5/13.
 */

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.liuyq")
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.liuyq")
@MapperScan(basePackages = "com.liuyq.**.mapper")
@EnableDistributedTransaction
public class ProviderApplication {

    public static void main(String[] agrs){
        SpringApplication.run(ProviderApplication.class, agrs);
    }

}
