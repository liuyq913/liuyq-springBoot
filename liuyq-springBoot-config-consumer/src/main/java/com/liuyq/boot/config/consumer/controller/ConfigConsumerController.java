package com.liuyq.boot.config.consumer.controller;

import com.liuyq.boot.config.consumer.config.ConusmerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuyq on 2019/5/15.
 */
@RefreshScope
@RestController
public class ConfigConsumerController {
    @Resource
    private ConusmerConfig conusmerConfig;

    @Value("${from}")
    private String from;


    @RequestMapping("/from")
    public String from() {

        return from;
    }
}
