package com.liuyq.boot.zuul.config;

import com.liuyq.boot.zuul.routelocator.LiuyqRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by liuyq on 2019/7/5.
 * 配置自定义的动态路由
 */
@Configurable
public class LiuyqRouteLocatorConf {
    @Autowired
     private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;


    @Bean
    public LiuyqRouteLocator routeLocator(){
        LiuyqRouteLocator liuyqRouteLocator = new LiuyqRouteLocator(serverProperties.getServlet().getContextPath(), zuulProperties);
        return liuyqRouteLocator;
    }
}
