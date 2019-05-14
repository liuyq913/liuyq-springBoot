package com.liuyq.springBoot.feign.two.web;

import com.liuyq.springBoot.feign.two.service.BootServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyq on 2019/5/14.
 */
@RestController
public class FeignTwoController {

    @Autowired
    BootServiceClient bootServiceClient;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
       return bootServiceClient.index();
    }
}
