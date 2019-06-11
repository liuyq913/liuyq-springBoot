package com.liuyq.boot.serviceB.Domain;

import com.liuyq.base.exception.BussinessException;
import com.liuyq.boot.serviceB.bo.DemoBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 21:51
 */
@FeignClient(value = "serviceB")
@RequestMapping("/sericeB")
public interface ServiceBDomain {

    @PostMapping("/save")
    Integer save(DemoBo demoBo) throws BussinessException;
}
