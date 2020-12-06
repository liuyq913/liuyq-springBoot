package com.liuyq.boot.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuqing
 * @className TestK8sController
 * @description TODO
 * @date 2020/12/4 4:55 下午
 */
@RestController
public class TestK8sController {

    @RequestMapping("/test")
    public void insert(){
        System.out.println("insert.....");
    }
}
