package com.liuyq.boot.serviceA.domain;

import com.liuyq.boot.serviceA.bo.DemoBo;
import com.liuyq.boot.serviceA.mapper.TxExceptionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:41
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ServiceANativeDomain implements ServiceADomain{
    @Resource
    private TxExceptionMapper demoMapper;
    @RequestMapping



    @Override
    public Integer save(DemoBo demo) {
        //return demoMapper.insertSelective(BeanUtil.convert(demo, Demo.class));
        demoMapper.selectByPrimaryKey(1L);
        return 1;
    }
}
