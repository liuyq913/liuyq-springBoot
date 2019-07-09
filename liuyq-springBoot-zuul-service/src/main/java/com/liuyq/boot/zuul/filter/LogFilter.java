package com.liuyq.boot.zuul.filter;

import com.liuyq.utils.http.HttpHandleFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liuyq on 2019/7/9. *
 * 日志处理
 */
@Component
public class LogFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String method = request.getMethod();//请求的类型，post get ..
        Map<String, String> params = HttpHandleFactory.getDefaultHandle().getAllRequestParam(request);
        String paramsStr = params.toString();//请求的参数
        long statrtTime = (long) context.get("startTime");//请求的开始时间
        Throwable throwable = context.getThrowable();//请求的异常，如果有的话
        String ip = request.getRequestURI();//请求的uri
        HttpHandleFactory.getDefaultHandle().getRequestIP(request);//请求的iP地址
        context.getResponseStatusCode();//请求的状态
        long duration = System.currentTimeMillis() - statrtTime;//请求耗时

        log.info("ip:{},请求类型{},请求参数{},请求耗时{}, 异常信息{} ", new Object[]{ip, method, paramsStr, duration, throwable.getMessage()});

        return null;
    }
}
