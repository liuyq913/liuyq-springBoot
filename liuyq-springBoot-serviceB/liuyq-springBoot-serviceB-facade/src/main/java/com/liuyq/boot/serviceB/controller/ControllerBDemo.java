package com.liuyq.boot.serviceB.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by liuyq on 2019/5/13.
 */
@RestController
@RequestMapping("/controllerADemo")
public class ControllerBDemo {
    private final Logger logger = LoggerFactory.getLogger(getClass());
}
