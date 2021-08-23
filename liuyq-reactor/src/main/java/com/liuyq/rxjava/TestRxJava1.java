package com.liuyq.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * @author liuyuqing
 * @className TestRxJava1
 * @description
 * @date 2021/8/20 4:16 下午
 */
public class TestRxJava1 {

    public static void main(String[] agrs) {

        // 相当于 观察者模式的subject(主题)   当订阅者订阅之后，立马执行 hello rxJava
        Observable<String> observable = Observable.create(sub -> {
            sub.onNext("hello rxJava");
            sub.onCompleted();
        });

        Observable<String> ob1 = Observable.just("1", "1", "2", "2", "3", "2", "3", "23");

        // 相当于 观察者模式当Observer 观察者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("done");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };


//        observable.subscribe(subscriber);

        ob1.subscribe(subscriber);


        // --------------简洁版---------------------


        Observable.create(
                sub -> {
                    sub.onNext("hello rxJava");
                    sub.onCompleted();
                }).subscribe(                     // 一下是观察者
                System.out::println,
                System.err::println,
                () -> System.out.println("done!"));


        Observable.concat(ob1, observable, Observable.just("!")).forEach(System.out::println);


    }
}
