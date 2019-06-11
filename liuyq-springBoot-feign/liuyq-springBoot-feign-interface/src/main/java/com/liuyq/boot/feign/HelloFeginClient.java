package com.liuyq.boot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuyq on 2019/5/14.
 */
@FeignClient(value = "cloud-feign-serviceA")
public interface HelloFeginClient {

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public Integer add(@RequestParam("a") Integer a , @RequestParam("n") Integer n);
}
