package com.liuyq.boot.zuul.process;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created by liuyq on 2019/7/5.
 * 继承FilterProcessor 过滤器处理器，因为error的过滤器，是可以将异常信息打印到客户端那里，
 * 然而error类型的过滤器又是把异常信息传递给了post类型的，SendErrorFilter，如果  post过滤器出了问题，那么异常就没有地方被打印出来
 * <p>
 * 这个process就是为了解决这个问题
 */
public class LiuyqFilterProcess extends FilterProcessor {


    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.set("failed.filter", filter); //将抛出异常的Filter 塞给RequestContext
            throw e;
        }
    }

}
