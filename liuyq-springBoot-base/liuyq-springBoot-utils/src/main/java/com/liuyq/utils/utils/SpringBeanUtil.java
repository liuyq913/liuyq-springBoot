package com.liuyq.utils.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by liuyq on 2019/4/16.
 *  获取spring配置的bean
 */
@Component
public final class SpringBeanUtil implements ApplicationContextAware{
    private static ApplicationContext  ctx ;

    private SpringBeanUtil()
    {
    }

    /**
     * 根据bean名称获取
     *
     * @param name
     * @return
     */
    public static Object getBean(String name)
    {
        return ctx.getBean(name);
    }

    public static <T> T getBean(Class<T> type)
    {
        Assert.notNull(type);
        return ctx.getBean(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
