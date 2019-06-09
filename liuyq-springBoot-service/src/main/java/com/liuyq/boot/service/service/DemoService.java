package com.liuyq.boot.service.service;

import com.liuyq.boot.service.mapper.DemoMapper;
import com.liuyq.boot.service.model.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuyq
 * @date 2019/6/9 0009 上午 9:51
 */
@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public Integer save(Demo demo){
        return demoMapper.insert(demo);
    }
}
