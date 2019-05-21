package com.liuyq.boot.consumer.availabiltytest;

public class AvailabilityPredicate extends AbstractPredicate{
    @Override
    public boolean apply(String key) {
        System.out.println("121212323");
        return false;
    }
}
