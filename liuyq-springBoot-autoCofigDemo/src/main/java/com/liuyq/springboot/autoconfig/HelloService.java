package com.liuyq.springboot.autoconfig;

import org.springframework.stereotype.Component;

/**
 * Created by liuyq on 2019/5/10.
 */
@Component
public class HelloService {
    private String msg = "service";//如果自动配置没有读入成功，那么为默认值

    public String say() {
        return "hello " + msg;
    }//为我们服务的方法

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
