package com.liuyq.boot.consumer.availabiltytest;

import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.CompositePredicate;

public class APredicate extends AbstractPredicate{

    private AbstractPredicate abstractPredicate;
    private Integer num;

    public APredicate(){}

    @Override
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


        public APredicate.Builder setNum(int num){
            aPredicate.num = num;
            return this;
        }

        public APredicate Builder(){
            return aPredicate;
        }

    }
}
