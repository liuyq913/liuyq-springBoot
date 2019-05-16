package com.liuyq.boot.config.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by liuyq on 2019/5/15.
 */
@RefreshScope
@Component
public class ConusmerConfig {

    @Value("${from}")
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
