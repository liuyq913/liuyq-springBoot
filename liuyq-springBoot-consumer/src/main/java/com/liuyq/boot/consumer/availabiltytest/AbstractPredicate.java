package com.liuyq.boot.consumer.availabiltytest;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.Server;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class AbstractPredicate implements Predicate{

    List<Server> getEligibleServers(List<Server> service, String key){
        return Lists.newArrayList();
    }

    @Override
    public  boolean apply(@Nullable Object var1){
        return true;
    }
}
