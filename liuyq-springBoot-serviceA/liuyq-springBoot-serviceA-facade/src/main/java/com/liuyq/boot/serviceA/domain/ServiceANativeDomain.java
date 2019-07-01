package com.liuyq.boot.serviceA.domain;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.liuyq.boot.redis.utils.RedisClustorUtil;
import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.boot.serviceA.mapper.TxExceptionMapper;
import com.liuyq.boot.serviceA.model.TxException;
import com.liuyq.boot.serviceB.Domain.ServiceBDomain;
import com.liuyq.boot.serviceB.bo.DemoBo;
import com.liuyq.utils.exception.BussinessException;
import com.liuyq.utils.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:41
 */
@Transactional(rollbackFor = Exception.class)
@Component
public class ServiceANativeDomain {
    @Resource
    private TxExceptionMapper demoMapper;
    @Resource
    private ServiceBDomain serviceBDomain;
    @Autowired
    private RedisClustorUtil redisClustorUtil;

    //@RequestMapping(value = "/save")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class) //开启本地事务（优先于类上的配置）
    @LcnTransaction //分布式事务注解（5.0.2不需要指是 isStart）
    public Integer save(@RequestBody TxExceptionBo exceptionBo) throws BussinessException {
        Integer num = demoMapper.insertSelective(BeanUtil.convert(exceptionBo, TxException.class));

        DemoBo demoBo = new DemoBo();
        demoBo.setApp_name("liuyq");
        demoBo.setCreate_time(new Date());
        demoBo.setDemo_field("liuyq");
        serviceBDomain.save(demoBo);
        return 1;
    }


    /**
     * 测试redis
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    public String set(String key, String value) {
        redisClustorUtil.set(key, value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return redisClustorUtil.getObject(key, String.class);
    }
}
