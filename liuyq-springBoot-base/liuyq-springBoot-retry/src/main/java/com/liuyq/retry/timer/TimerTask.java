package com.liuyq.retry.timer;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 15:12
 * @Description: 重试具体任务接口
 */
public interface TimerTask {
    /**
     * Executed after the delay specified with
     * {@link Timer#newTimeout(TimerTask, long, TimeUnit)}.
     *
     * @param timeout a handle which is associated with this task
     */
    void run(Timeout timeout) throws Exception;
}
