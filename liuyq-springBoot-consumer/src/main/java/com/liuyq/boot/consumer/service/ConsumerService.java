package com.liuyq.boot.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuyq on 2019/5/15.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    //Ribbon中是用hystrix
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(){
        return restTemplate.getForEntity("http://BOOT-SERVICE/hello", String.class).getBody();
    }

    public String addServiceFallback(){
        return "error";
    }
}
