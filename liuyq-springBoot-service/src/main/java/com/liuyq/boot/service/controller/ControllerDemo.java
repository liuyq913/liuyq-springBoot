package com.liuyq.boot.service.controller;

import com.liuyq.boot.service.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by liuyq on 2019/5/13.
 */
@RestController
public class ControllerDemo {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        String s = client.description();

        logger.info("/hello  description:"+s);
        return "providerDemo";
    }


}
