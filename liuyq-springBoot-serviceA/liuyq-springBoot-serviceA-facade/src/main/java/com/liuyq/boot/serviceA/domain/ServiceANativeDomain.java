package com.liuyq.boot.serviceA.domain;

import com.liuyq.base.utils.BeanUtil;
import com.liuyq.boot.serviceA.bo.TxExceptionBo;
import com.liuyq.boot.serviceA.mapper.TxExceptionMapper;
import com.liuyq.boot.serviceA.model.TxException;
import com.liuyq.boot.serviceB.Domain.ServiceBDomain;
import com.liuyq.boot.serviceB.bo.DemoBo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:41
 */
@Transactional(rollbackFor = Exception.class)
@RestController
public class ServiceANativeDomain{
    @Resource
    private TxExceptionMapper demoMapper;
    @Resource
    private ServiceBDomain serviceBDomain;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Integer save(@RequestBody TxExceptionBo exceptionBo) {
        Integer num = demoMapper.insertSelective(BeanUtil.convert(exceptionBo, TxException.class));

        DemoBo demoBo = new DemoBo();
        demoBo.setApp_name("liuyq");
        demoBo.setCreate_time(new Date());
        demoBo.setDemo_field("liuyq");
        try {
            serviceBDomain.save(demoBo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
}
