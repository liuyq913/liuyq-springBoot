package com.liuyq.seeemitter;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyuqing
 * @className PayCompletedListener
 * @description
 * @date 2021/8/23 11:33 上午
 */
@Component
public class PayCompletedListener {
    private static Map<Long, SseEmitter> sseEmitters = new Hashtable<>();
    private AtomicInteger row = new AtomicInteger();

    public void addSseEmitters(Long payRecordId, SseEmitter sseEmitter) {
        sseEmitters.put(payRecordId, sseEmitter);
    }

    @EventListener
    public void deployEventHandler(PayCompletedEvent payCompletedEvent) throws IOException {
        Long payRecordId = payCompletedEvent.getPayRecordId();
        SseEmitter sseEmitter = sseEmitters.get(payRecordId);
        sseEmitter.send("send" + UUID.randomUUID().toString());
        // Integer current = row.incrementAndGet();
        sseEmitter.complete();
        //if (current == 10) {
        //  sseEmitter.complete();
        // }

    }
}

