package com.liuyq.boot.consumer.availabiltytest;

import org.springframework.lang.Nullable;

public class AvailabilityPredicate extends AbstractPredicate{

    @Override
    public boolean apply(@Nullable Object var1) {
        System.out.println("121212323");
        return false;
    }
}
