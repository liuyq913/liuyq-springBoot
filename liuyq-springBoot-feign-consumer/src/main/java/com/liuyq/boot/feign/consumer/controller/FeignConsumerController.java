package com.liuyq.boot.feign.consumer.controller;

import com.liuyq.boot.feign.HelloFeginClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuyq on 2019/5/13.
 */
@RestController
public class FeignConsumerController {


    @Resource
    HelloFeginClient helloFeginClient;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return helloFeginClient.add(a, b);
    }


}
