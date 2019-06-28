package com.liuyq.boot.serviceA.domain;

import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.utils.exception.BussinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:40
 */
@FeignClient(value = "serviceA")
public interface ServiceADomain {

    @RequestMapping(value = "/save")
    public Integer save(@RequestParam("exceptionBo") TxExceptionBo exceptionBo) throws BussinessException;
}
