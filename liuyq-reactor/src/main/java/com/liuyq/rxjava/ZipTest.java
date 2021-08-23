package com.liuyq.rxjava;

import rx.Observable;

/**
 * @author liuyuqing
 * @className ZipTest
 * @description
 * @date 2021/8/21 1:28 下午
 */
public class ZipTest {
    public static void main(String[] args) {

        Observable zip = Observable.zip(
                Observable.just("1", "2"),
                Observable.just("1", "2"),
                (x, y) -> x + y
        );

        zip.subscribe(sub -> System.out.println(sub));
    }
}
