package com.liuyq.boot.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * Created by liuyq on 2019/7/5.
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {
    @Override
    public int filterOrder() {
        return 30; //大于ErrorFilter的值
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter filter = (ZuulFilter) ctx.get("failed.filter");

        if(filter != null && filter.filterType().equals("post")){
            return true;
        }else{
            return false;
        }
    }
}
