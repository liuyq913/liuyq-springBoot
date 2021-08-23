package com.liuyq.rxjava.pub_sub_app;

import org.springframework.stereotype.Component;
import rx.Observable;

import java.util.Random;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author liuyuqing
 * @className TemperatureSensor
 * @description 温度发射器
 * @date 2021/8/21 1:56 下午
 */
@Component
public class TemperatureSensor {

    private final Random rnd = new Random();


    private final Observable<Temperature> dataStream =
            Observable
                    .range(0, Integer.MAX_VALUE)
                    .concatMap(tick -> Observable.just(tick)
                            .delay(rnd.nextInt(5000), MILLISECONDS)
                            .map(tickVa1ue -> this.probe()))
                    .publish()
                    .refCount();

    private Temperature probe() {
        return new Temperature(16 + rnd.nextGaussian() * 10);
    }


    public Observable<Temperature> temperatureStream() {
        return dataStream;
    }
}
