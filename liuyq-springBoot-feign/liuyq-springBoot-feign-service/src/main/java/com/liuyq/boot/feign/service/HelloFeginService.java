package com.liuyq.boot.feign.service;

import org.springframework.stereotype.Service;

/**
 * Created by liuyq on 2019/5/14.
 */
@Service
public class HelloFeginService {

    public Integer add(Integer a, Integer n){
        return  a+n;
    }
}
