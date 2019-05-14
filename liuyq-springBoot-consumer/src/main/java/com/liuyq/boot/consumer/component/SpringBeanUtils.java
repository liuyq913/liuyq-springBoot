package com.liuyq.boot.consumer.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by liuyq on 2019/5/14.
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringBeanUtils.applicationContext == null){
            SpringBeanUtils.applicationContext =  applicationContext;
        }
        logger.info("SpringBeanUtils在载入容器完成");

    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> type){
        return applicationContext.getBean(type);
    }
}
