package com.liuyq.boot.zuul.service;

import com.liuyq.boot.zuul.mapper.ApiConfigMapper;
import com.liuyq.boot.zuul.model.ApiConfig;
import com.liuyq.boot.zuul.model.ApiConfigExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by liuyq on 2019/7/5.
 */
@Service
public class ApiConfigService {
    @Resource
    private ApiConfigMapper apiConfigMapper;

    public List<ApiConfig> findByLastUpdateTime(Date lastUpdateTime) {
        ApiConfigExample example = new ApiConfigExample();
        ApiConfigExample.Criteria criteria = example.createCriteria();
        if (lastUpdateTime != null) {
            criteria.andModifyTimeGreaterThanOrEqualTo(lastUpdateTime);
        }
        example.setOrderByClause("FModifyTime desc");
        return this.apiConfigMapper.selectByExample(example);
    }
}
