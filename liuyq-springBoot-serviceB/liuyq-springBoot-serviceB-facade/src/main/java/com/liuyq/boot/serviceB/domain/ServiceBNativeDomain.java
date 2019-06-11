package com.liuyq.boot.serviceB.domain;

import com.liuyq.base.exception.BussinessException;
import com.liuyq.base.utils.BeanUtil;
import com.liuyq.boot.serviceB.Domain.ServiceBDomain;
import com.liuyq.boot.serviceB.bo.DemoBo;
import com.liuyq.boot.serviceB.mapper.DemoMapper;
import com.liuyq.boot.serviceB.model.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:41
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ServiceBNativeDomain implements ServiceBDomain {
    @Resource
    private DemoMapper demoMapper;


    @Override
    public Integer save(DemoBo demoBo) throws BussinessException{

        demoMapper.insertSelective(BeanUtil.convert(demoBo, Demo.class));
        throw new BussinessException("给你一个异常");
    }
}
