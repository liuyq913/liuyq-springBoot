package com.liuyq.seeemitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author liuyuqing
 * @className SseController
 * @description
 * @date 2021/8/23 11:32 上午
 */
@RestController
public class SseController {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    PayCompletedListener payCompletedListener;

    @GetMapping("/push")
    public SseEmitter push(@RequestParam Long payRecordId){
        final SseEmitter emitter = new SseEmitter(0L);
        try {
            payCompletedListener.addSseEmitters(payRecordId,emitter);
        }catch (Exception e){
            emitter.completeWithError(e);
        }

        return emitter;
    }

    @GetMapping("/pay-callback")
    public String payCallback(@RequestParam Long payRecordId){
        applicationContext.publishEvent(new PayCompletedEvent(this,payRecordId));
        return "请到监听处查看消息";

    }

}

