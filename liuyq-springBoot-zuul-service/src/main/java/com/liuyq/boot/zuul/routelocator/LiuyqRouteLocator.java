package com.liuyq.boot.zuul.routelocator;

import com.google.common.collect.Maps;
import com.liuyq.boot.zuul.model.ApiConfig;
import com.liuyq.boot.zuul.service.ApiConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyq on 2019/7/5.
 * 路由定位器，从库里面读取路由来
 */
public class LiuyqRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public final static Logger logger = LoggerFactory.getLogger(LiuyqRouteLocator.class);

    private ZuulProperties properties;

    @Resource
    private ApiConfigService apiConfigService;


    public LiuyqRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    public void refresh() {
        super.doRefresh();
    }


    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<String, ZuulProperties.ZuulRoute>();

        //从application.properties中加载路由信息
        routesMap.putAll(super.locateRoutes());
        //从db中加载路由信息
        routesMap.putAll(locateRoutesFromDB()); //putAll  push的值不能为null,会抛空指针
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {

            String path = entry.getKey();
            if (!path.startsWith("/")) {
                path = "/" + path;
            }

            if (StringUtils.hasText(this.properties.getPrefix())) {

                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }

            values.put(path, entry.getValue());
        }

        return values;
    }

    /**
     * 查到所有的路由
     *
     * @return
     */
    private Map<String, ZuulProperties.ZuulRoute> locateRoutesFromDB() {
        Map<String, ZuulProperties.ZuulRoute> dbRoutes = Maps.newHashMap();
        List<ApiConfig> apiConfigList = apiConfigService.findByLastUpdateTime(null);
        if (CollectionUtils.isEmpty(apiConfigList)) {
            return dbRoutes;
        }


        for (ApiConfig apiConfig : apiConfigList) {
            if (StringUtils.isEmpty(apiConfig.getGatewayUrl()) || StringUtils.isEmpty(apiConfig.getUrl())) {
                continue;
            }

            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
            try {
                zuulRoute.setId(apiConfig.getCode());
                zuulRoute.setPath(apiConfig.getGatewayUrl());
                zuulRoute.setUrl(apiConfig.getUrl());
                zuulRoute.setStripPrefix(true);
            } catch (Exception e) {
                logger.error("从数据库中加载路由列表出现错误：", e);
            }
            dbRoutes.put(zuulRoute.getPath(), zuulRoute);
        }
        return dbRoutes;
    }
}
