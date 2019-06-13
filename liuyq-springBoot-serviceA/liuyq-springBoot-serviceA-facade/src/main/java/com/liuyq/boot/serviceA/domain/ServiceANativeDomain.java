package com.liuyq.boot.serviceA.domain;

import com.liuyq.base.exception.BussinessException;
import com.liuyq.base.utils.BeanUtil;
import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.boot.serviceA.mapper.TxExceptionMapper;
import com.liuyq.boot.serviceA.model.TxException;
import com.liuyq.boot.serviceB.Domain.ServiceBDomain;
import com.liuyq.boot.serviceB.bo.DemoBo;
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
public class ServiceANativeDomain implements ServiceADomain{
    @Resource
    private TxExceptionMapper demoMapper;
    @Resource
    private ServiceBDomain serviceBDomain;

    //@RequestMapping(value = "/save")
    @Override
    @ResponseBody
    public Integer save(@RequestBody TxExceptionBo exceptionBo) throws BussinessException {
        Integer num = demoMapper.insertSelective(BeanUtil.convert(exceptionBo, TxException.class));

        DemoBo demoBo = new DemoBo();
        demoBo.setApp_name("liuyq");
        demoBo.setCreate_time(new Date());
        demoBo.setDemo_field("liuyq");
        serviceBDomain.save(demoBo);
        return 1;
    }
}
