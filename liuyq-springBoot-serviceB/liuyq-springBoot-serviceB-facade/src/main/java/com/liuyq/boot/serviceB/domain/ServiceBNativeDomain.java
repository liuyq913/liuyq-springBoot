package com.liuyq.boot.serviceB.domain;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.liuyq.boot.serviceB.bo.DemoBo;
import com.liuyq.boot.serviceB.mapper.DemoMapper;
import com.liuyq.boot.serviceB.model.Demo;
import com.liuyq.utils.exception.BussinessException;
import com.liuyq.utils.utils.BeanUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 19:41
 */
@Transactional(rollbackFor = Exception.class)
@RestController
public class ServiceBNativeDomain{
    @Resource
    private DemoMapper demoMapper;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class) //开启本地事务（优先于类上的配置）
    @LcnTransaction //分布式事务注解（5.0.2不需要指是 isStart）
    public Integer save(@RequestBody DemoBo demoBo) throws BussinessException {

        demoMapper.insertSelective(BeanUtil.convert(demoBo, Demo.class));
        throw new BussinessException("给你一个异常");
        //return 1;
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    @ResponseBody
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b")Integer b){
        return a+b;
    }
}
