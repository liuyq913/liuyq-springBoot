package com.liuyq.springBoot.feign.two.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liuyq on 2019/5/14.
 */
@FeignClient(value = "boot-service")
public interface BootServiceClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index();
}
