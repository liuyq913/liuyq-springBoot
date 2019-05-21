package com.liuyq.boot.feign.controller;

import com.liuyq.boot.feign.service.HelloFeginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuyq on 2019/5/14.
 */
@RestController
public class HelloFeginController {
    @Resource
    HelloFeginService helloFeginService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(Integer a, Integer n) {
        return helloFeginService.add(a, n);
    }
}

