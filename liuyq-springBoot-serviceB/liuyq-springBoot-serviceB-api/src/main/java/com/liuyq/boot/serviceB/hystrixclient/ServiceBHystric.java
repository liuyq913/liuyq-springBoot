package com.liuyq.boot.serviceB.hystrixclient;


import com.liuyq.boot.serviceB.Domain.ServiceBDomain;
import com.liuyq.boot.serviceB.bo.DemoBo;
import com.liuyq.utils.exception.BussinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liuyq on 2019/7/1.
 */
@Component
public class ServiceBHystric implements ServiceBDomain {

    @Override
    public Integer save(@RequestBody DemoBo demoBo) throws BussinessException {
        System.out.println("进入断路器");
        return 0;
    }

    @Override
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) throws BussinessException {
        System.out.println("进入断路器");
        return 0;
    }

    @Override
    public Integer saveList(@RequestBody List<DemoBo> demoBo) {
        System.out.println("进入断路器");
        return 0;
    }

    @Override
    public Integer testInsert() {
        System.out.println("进入断路器");
        return 0;
    }
}
