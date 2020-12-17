package com.liuyq.boot.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuqing
 * @className TestK8sController
 * @description TODO
 * @date 2020/12/4 4:55 下午
 */

@RestController
public class TestK8sController implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(TestK8sController.class);

    @RequestMapping("/insert")
    public void insert() {
        System.out.println("insert.....");
    }

    @RequestMapping("/sentry")
    public void testSentry() throws Exception {
        logger.error("test sentry");
        throw new Exception("test exception");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                logger.error("test sentry insert");
                try {
                    throw new Exception("test exception insert");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
