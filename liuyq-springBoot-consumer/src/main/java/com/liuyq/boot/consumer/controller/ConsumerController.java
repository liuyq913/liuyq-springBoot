package com.liuyq.boot.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuyq on 2019/5/13.
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value ="/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return  restTemplate.getForEntity("http://BOOT-SERVICE/hello", String.class).getBody();
    }
}
