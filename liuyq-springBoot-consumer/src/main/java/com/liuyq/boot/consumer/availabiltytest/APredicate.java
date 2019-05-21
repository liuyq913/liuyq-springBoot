package com.liuyq.boot.consumer.availabiltytest;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.netflix.loadbalancer.Server;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public class APredicate extends AbstractPredicate{

    private AbstractPredicate abstractPredicate;
    private Integer num;
    private List<AbstractPredicate> litte;

    public APredicate(){}


    public boolean apply(String key) {
        return abstractPredicate.apply(key);
    }


    public static class Builder {
        APredicate aPredicate = new APredicate();


        Builder(AbstractPredicate abstractPredicate) {
            this.aPredicate.abstractPredicate = abstractPredicate;
        }

        public static APredicate.Builder withPredicate(AbstractPredicate primaryPredicate) {
            return new APredicate.Builder(primaryPredicate);
        }

        public APredicate.Builder add(AbstractPredicate... primaryPredicate) {
            aPredicate.litte  = (List)Predicates.and(primaryPredicate);
            return this;
        }



        public APredicate.Builder setNum(int num){
            aPredicate.num = num;
            return this;
        }

        public APredicate Builder(){
            return aPredicate;
        }

    }
    public List<Server> getEligibleServers(List<Server> servers , Object loadBalancerKey){
        for(AbstractPredicate o :  litte){
            o.getEligibleServers(servers, loadBalancerKey);
        }
    }
}
