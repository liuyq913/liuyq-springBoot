package com.liuyq.boot.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyq on 2019/5/15.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    //Ribbon中是用hystrix   服务降级
    @HystrixCommand(fallbackMethod = "helloServiceFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://SERVICEA/insert", String.class).getBody();
    }


    ////ignoreExceptions 忽略某种异常，让他不走降级服务
    @HystrixCommand(fallbackMethod = "addServiceFallback", ignoreExceptions = {HystrixBadRequestException.class})
    @CacheResult(cacheKeyMethod = "cacheKeyID") //设置结果缓存
    public Integer addService(Integer o) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("n", 3);
        return restTemplate.getForEntity("http://CLOUD-FEIGN-SERVICE/add?a={a}&n={n}", Integer.class, map).getBody();
    }


    public String helloServiceFallback() {
        return "error";
    }

    public Integer addServiceFallback(Integer o, Throwable e) {
        System.out.println(e.getMessage());  //异常获取
        return 0;
    }

    public Integer cacheKeyID(Integer o){
        return o;
    }
}
