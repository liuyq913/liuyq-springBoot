package com.liuyq.rxjava;

import rx.Observable;
import rx.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * @author liuyuqing
 * @className IntervalTest
 * @description
 * @date 2021/8/20 5:06 下午
 */
public class IntervalTest {
    public static void main(String[] agrs) throws InterruptedException {
        // 延时

        // Subscription 是发布者和消费者关联关系的维护
        Subscription subscription =
                Observable.interval(1, TimeUnit.SECONDS).subscribe(e -> System.out.println("get :" + e));

        Thread.sleep(5000);

        subscription.unsubscribe();
    }


}
