package com.liuyq.boot.serviceA.controller;

import com.liuyq.lcn.exception.BussinessException;
import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.boot.serviceA.domain.ServiceANativeDomain;
import com.liuyq.boot.serviceB.Domain.ServiceBDomain;
import com.liuyq.boot.serviceB.bo.DemoBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private ServiceANativeDomain serviceADomain;

    @Resource
    private ServiceBDomain serviceBDomain;

    @RequestMapping("/insert")
    public void insert() {
        TxExceptionBo txExceptionBo = new TxExceptionBo();
        txExceptionBo.setCreate_time(new Date());
        txExceptionBo.setEx_state(Byte.valueOf("1"));
        txExceptionBo.setMod_id("123");
        try {
            serviceADomain.save(txExceptionBo);
        }catch (Exception e){}
    }

    @RequestMapping(value = "/testServiceB", method = RequestMethod.GET)
    public void testServiceB(){
        DemoBo demoBo = new DemoBo();
        demoBo.setApp_name("liuyq");
        try {
            serviceBDomain.save(demoBo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/testServiceBAdd", method = RequestMethod.GET)
    public Integer testServiceAdd(@RequestParam("a")Integer a, @RequestParam("b")Integer b) throws BussinessException {
        return serviceBDomain.add(a,b);
    }
}
