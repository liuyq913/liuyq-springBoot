package com.liuyq.boot.eureka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuqing
 * @className TestConroller
 * @description TODO
 * @date 2020/12/5 10:41 下午
 */
@RestController
public class TestController {

    @RequestMapping("/insert")
    public void insert(){
        System.out.println("insert.....");
    }
}
