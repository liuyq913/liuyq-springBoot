package com.liuyq.boot.serviceA.controller;

import com.liuyq.boot.serviceA.bo.DemoBo;
import com.liuyq.boot.serviceA.domain.ServiceANativeDomain;
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
@RequestMapping("/controllerADemo")
public class ControllerADemo {
    private final Logger logger = LoggerFactory.getLogger(getClass());

   @Resource
   ServiceANativeDomain serviceANativeDomain;

   @RequestMapping("/insert")
    public void insert(){
       DemoBo demoBo = new DemoBo();
       demoBo.setApp_name("1111");
       demoBo.setDemo_field("1111");
       demoBo.setGroup_id("1111");
       serviceANativeDomain.save(demoBo);
   }
}
