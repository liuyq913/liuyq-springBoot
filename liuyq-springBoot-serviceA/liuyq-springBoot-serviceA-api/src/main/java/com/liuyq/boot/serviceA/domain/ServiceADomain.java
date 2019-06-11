package com.liuyq.boot.serviceA.domain;

import com.liuyq.boot.serviceA.bo.DemoBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:40
 */
@FeignClient(value = "cloud-feign-serviceA")
@RequestMapping("/sericeA")
public interface ServiceADomain {

    @RequestMapping("/save")
    Integer save(DemoBo demo);
}
