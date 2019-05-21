package com.liuyq.boot.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyq on 2019/5/15.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    //Ribbon中是用hystrix
    @HystrixCommand(fallbackMethod = "helloServiceFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://BOOT-SERVICE/hello", String.class).getBody();
    }


    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public Integer addService() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("n", 3);
        return restTemplate.getForEntity("http://CLOUD-FEIGN-SERVICE/add?a={a}&n={n}", Integer.class, map).getBody();
    }


    public String helloServiceFallback() {
        return "error";
    }

    public Integer addServiceFallback() {
        return 0;
    }
}
