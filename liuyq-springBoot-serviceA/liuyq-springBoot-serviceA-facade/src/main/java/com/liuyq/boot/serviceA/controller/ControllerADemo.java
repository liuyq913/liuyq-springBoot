package com.liuyq.boot.serviceA.controller;

import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.boot.serviceA.domain.ServiceANativeDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


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
       TxExceptionBo txExceptionBo = new TxExceptionBo();
       txExceptionBo.setCreate_time(new Date());
       txExceptionBo.setEx_state(Byte.valueOf("1"));
       txExceptionBo.setMod_id("123");
       serviceANativeDomain.save(txExceptionBo);
   }
}
