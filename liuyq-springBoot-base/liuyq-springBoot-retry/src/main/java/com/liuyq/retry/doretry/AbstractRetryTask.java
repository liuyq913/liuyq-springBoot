package com.liuyq.retry.doretry;

import com.liuyq.retry.timer.Timeout;
import com.liuyq.retry.timer.Timer;
import com.liuyq.retry.timer.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 15:35
 * @Description: 重试抽象实现
 */
public abstract class AbstractRetryTask implements TimerTask {

    private final String taskName; //任务名称
    /**
     * retry period 重试间隔
     */
    final long retryPeriod;

    /**
     * define the most retry times
     */
    private final int retryTimes;
    //重试次数
    private int times = 1;
    private volatile boolean cancel;

    AbstractRetryTask(String taskName, long retryPeriod, int retryTimes) {
        this.taskName = taskName;
        this.retryPeriod = retryPeriod;
        this.retryTimes = retryTimes;
        this.cancel = false;
    }

    //取消
    public void cancel(boolean cancel) {
        this.cancel = true;
    }

    public boolean isCancel() {
        return cancel;
    }

    /**
     * 重试
     *
     * @param timeout 任务及 任务执行者处理器
     * @param delay   延时时间
     */
    protected void reput(Timeout timeout, long delay) {
        if (timeout == null) {
            throw new IllegalArgumentException();
        }

        Timer timer = timeout.timer();
        if (timer.isStop() || timeout.isCancelled() || isCancel()) {
            return;
        }
        times++;
        timer.newTimeout(timeout.task(), delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run(Timeout timeout) throws Exception {
        if (timeout.timer().isStop() || isCancel()) return;
        if (times > retryTimes) return;
        try {
            this.doRetry(timeout);
        } catch (Exception e) {
            reput(timeout, retryPeriod);
        }
    }

    //由子类实现模版方法
    public abstract void doRetry(Timeout timeout);
}
