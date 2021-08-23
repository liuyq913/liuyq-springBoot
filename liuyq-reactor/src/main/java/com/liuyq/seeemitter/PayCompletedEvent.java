package com.liuyq.seeemitter;

import org.springframework.context.ApplicationEvent;

/**
 * @author liuyuqing
 * @className PayCompletedEvent
 * @description
 * @date 2021/8/23 11:32 上午
 */
public class PayCompletedEvent extends ApplicationEvent {
    private Long payRecordId;

    public PayCompletedEvent(Object source, Long payRecordId) {
        super(source);
        this.payRecordId = payRecordId;
    }

    public Long getPayRecordId() {
        return payRecordId;
    }

    public void setPayRecordId(Long payRecordId) {
        this.payRecordId = payRecordId;
    }
}

