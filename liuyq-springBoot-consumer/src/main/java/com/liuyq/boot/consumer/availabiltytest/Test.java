package com.liuyq.boot.consumer.availabiltytest;

public class Test{
    private AbstractPredicate abstractPredicate = APredicate.Builder.withPredicate(new APredicate()).Builder();

    public void choose(String key){
        abstractPredicate.apply(key);
    }



    public static void main(String[] gars){
        Test test = new Test();
        test.choose("12");
    }
}
