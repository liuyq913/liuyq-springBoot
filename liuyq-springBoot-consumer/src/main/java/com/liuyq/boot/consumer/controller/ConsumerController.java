package com.liuyq.boot.consumer.controller;

import com.liuyq.boot.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyq on 2019/5/13.
 */
@RestController
public class ConsumerController {

    /*@Autowired
    RestTemplate restTemplate;

    @Resource
    HelloFeginClient helloFeginClient;*/

    @Autowired
    ConsumerService consumerService;



    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return consumerService.helloService();
    }

    @RequestMapping(value = "/ribbon-consumer2", method = RequestMethod.GET)
    public Integer addService(){
        return consumerService.addService();
    }

  /*  @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return helloFeginClient.add(a, b);
    }*/

}
