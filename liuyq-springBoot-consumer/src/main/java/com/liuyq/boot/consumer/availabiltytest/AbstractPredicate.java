package com.liuyq.boot.consumer.availabiltytest;

import com.google.common.collect.Lists;
import org.springframework.lang.Nullable;

import javax.jws.Oneway;
import javax.management.ObjectName;
import javax.print.DocFlavor;
import java.util.List;

public abstract class AbstractPredicate implements Predicate{

    List<Object> getEligibleServers(List<AbstractPredicate> service, String key){
        return Lists.newArrayList();
    }

    public  boolean apply(@Nullable Object var1){
        return true;
    }
}
