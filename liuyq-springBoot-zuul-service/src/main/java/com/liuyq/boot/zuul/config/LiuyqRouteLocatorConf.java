package com.liuyq.boot.zuul.config;

import com.liuyq.boot.zuul.routelocator.LiuyqRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuyq on 2019/7/5.
 * 配置自定义的动态路由
 */
@Configuration
public class LiuyqRouteLocatorConf {
    @Autowired
     private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    /**
     * 仿照 ZuulServerAutoConfiguration 生成 路由定位器
     * @return
     */
    @Bean
    public LiuyqRouteLocator routeLocator(){
        LiuyqRouteLocator liuyqRouteLocator = new LiuyqRouteLocator(serverProperties.getServlet().getContextPath(), zuulProperties);
        return liuyqRouteLocator;
    }
}
