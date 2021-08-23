package com.liuyq.rxjava.pub_sub_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuyuqing
 * @className TemperatureController
 * @description
 * @date 2021/8/23 2:26 下午
 */
@RestController
public class TemperatureController {

    private TemperatureSensor temperatureSensor;

    public TemperatureController(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    @RequestMapping(
            value = "temperature-stream",
            method = RequestMethod.GET)
    public SseEmitter events(HttpServletRequest request) {

        RxSeeEmitter emitter = new RxSeeEmitter();
        temperatureSensor.temperatureStream().subscribe(emitter.getSubscriber());
        return emitter;
    }

}
