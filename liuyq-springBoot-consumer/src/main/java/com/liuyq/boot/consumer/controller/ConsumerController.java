package com.liuyq.boot.consumer.controller;

import com.liuyq.boot.feign.HelloFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by liuyq on 2019/5/13.
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Resource(name = "com.liuyq.boot.feign.HelloFeginClient")
    HelloFeginClient helloFeginClient;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://BOOT-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return helloFeginClient.add(a, b);
    }


}
