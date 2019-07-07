package com.liuyq.boot.zuul.schedule;

import com.liuyq.boot.zuul.service.RouteLocatiorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liuyq on 2019/7/5.
 */
@Service
public class RefreshRouteSchedule {

    @Resource
    private RouteLocatiorService routeLocatiorService;

    @Scheduled(fixedRate = 5000)
    public void duRefresh(){
        routeLocatiorService.refreshRouteLocator();
    }
}
