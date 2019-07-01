package com.liuyq.boot.serviceA.hystricclient;

import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.boot.serviceA.domain.ServiceADomain;
import com.liuyq.utils.exception.BussinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuyq on 2019/7/1.
 */
@Component
public class ServiceAHystric implements ServiceADomain {
    @Override
    public Integer save(@RequestParam("exceptionBo") TxExceptionBo exceptionBo) throws BussinessException {
        System.out.println("进入断路器。。。。。save");
        return 0;
    }
}
