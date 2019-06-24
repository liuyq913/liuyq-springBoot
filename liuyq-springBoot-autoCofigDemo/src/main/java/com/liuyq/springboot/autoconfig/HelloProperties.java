package com.liuyq.springboot.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by liuyq on 2019/5/10.
 */
//读配置文件里面的值
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private String msg = "default";


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
