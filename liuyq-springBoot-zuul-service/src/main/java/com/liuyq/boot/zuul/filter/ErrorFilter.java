package com.liuyq.boot.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyq on 2019/7/5.
 * error  类型的过滤器，在 pre route post 阶段中有异常抛出都会被error异常捕获，然后将异常信息处理，返回给客户端
 */
public class ErrorFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        Throwable throwable = ctx.getThrowable();
        ctx.set("error_status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // error_status_code有值才会将异常信息流转到后续的SendErrorFilter中
        ctx.set("error.exception", throwable.getCause());
        return null;
    }
}
