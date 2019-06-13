package com.liuyq.boot.serviceB.Domain;

import com.liuyq.base.exception.BussinessException;
import com.liuyq.boot.serviceB.bo.DemoBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 21:51
 */
@FeignClient(value = "serviceB")
public interface ServiceBDomain {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    Integer save(@RequestBody DemoBo demoBo) throws BussinessException;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) throws BussinessException;
}
