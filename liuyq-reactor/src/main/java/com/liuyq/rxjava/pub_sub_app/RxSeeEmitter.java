package com.liuyq.rxjava.pub_sub_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import rx.Subscriber;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyuqing
 * @className RxSeeErnitter
 * @descriptio
 * @date 2021/8/23 10:21 上午
 */
public class RxSeeEmitter extends SseEmitter {
    private static final Logger log = LoggerFactory.getLogger(RxSeeEmitter.class);

    static final long SSE_SESSION_TIMEOUT = 30 * 60 * 1000L;
    private final static AtomicInteger sessionIdSequence = new AtomicInteger(0);

    private final int sessionId = sessionIdSequence.incrementAndGet();
    private final Subscriber<Temperature> subscriber;

    RxSeeEmitter() {
        super(SSE_SESSION_TIMEOUT); // sse 超时时间

        // 创建订阅者
        this.subscriber = new Subscriber<Temperature>() {
            @Override
            public void onNext(Temperature temperature) {
                try {
                    RxSeeEmitter.this.send(temperature);
                    log.info("[{}] << {} ", sessionId, temperature.getValue());
                } catch (IOException e) {
                    log.warn("[{}] Can not send event to SSE, closing subscription, message: {}",
                            sessionId, e.getMessage());
                    unsubscribe();
                }
            }

            @Override
            public void onError(Throwable e) {
                log.warn("[{}] Received sensor error: {}", sessionId, e.getMessage());
            }

            @Override
            public void onCompleted() {
                log.warn("[{}] Stream completed", sessionId);
            }
        };

        // sse 完成
        onCompletion(() -> {
            log.info("[{}] SSE completed", sessionId);
            subscriber.unsubscribe(); // 取消订阅
        });

        // sse 超时回调
        onTimeout(() -> {
            log.info("[{}] SSE timeout", sessionId);
            subscriber.unsubscribe();
        });
    }

    Subscriber<Temperature> getSubscriber() {
        return subscriber;
    }

    int getSessionId() {
        return sessionId;
    }
}
