package com.liuyq.springBoot.feign.two.hystrix;

import com.liuyq.springBoot.feign.two.service.BootServiceClient;
import org.springframework.stereotype.Component;

/**
 * Created by liuyq on 2019/5/15.
 */
@Component
public class BootServiceClientHystrix implements BootServiceClient{


    @Override
    public String index() {
        return "error";
    }
}
