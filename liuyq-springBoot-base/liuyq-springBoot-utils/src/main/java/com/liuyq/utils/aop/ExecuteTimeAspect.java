package com.liuyq.utils.aop;

import com.liuyq.utils.servlet.ServletContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问时间切面
 */
@Aspect
public class ExecuteTimeAspect {

    private static Logger logger = LoggerFactory.getLogger(ExecuteTimeAspect.class);

    /**
     * 权限检查切入点
     */
    @Pointcut("execution(public * com.liuyq..controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void executeTime() {

    }

    @Around("executeTime()")
    public Object executeTime(ProceedingJoinPoint invocation) throws Throwable {
        HttpServletRequest request = ServletContextHolder.getRequest();
        String requestURI = request == null ? StringUtils.EMPTY : request.getRequestURI();
        long time1 = System.currentTimeMillis();
        Object obj = invocation.proceed();
        long time2 = System.currentTimeMillis();
        long cost = time2 - time1;
        logger.info("{} execute {} ms", requestURI, cost);
        if (cost > 300) {
            logger.info("{} execute {} ms", requestURI, time2 - time1);
        }
        return obj;
    }
}
