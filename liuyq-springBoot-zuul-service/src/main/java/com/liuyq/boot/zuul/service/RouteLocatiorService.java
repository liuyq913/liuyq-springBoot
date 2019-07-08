package com.liuyq.boot.zuul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by liuyq on 2019/7/5.
 */
@Service
public class RouteLocatiorService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private RouteLocator routeLocator;

    public void refreshRouteLocator(){
        //发布刷新路由的事件  zuulConfigure配置了事件监听器
        applicationEventPublisher.publishEvent(new RoutesRefreshedEvent(routeLocator));
    }

}
