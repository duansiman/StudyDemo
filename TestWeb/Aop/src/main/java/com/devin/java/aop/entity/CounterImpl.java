package com.devin.java.aop.entity;

/**
 * Created by devin on 2017/2/6.
 */
public class CounterImpl implements ICounter {

    private int counter;

    @Override
    public int getCounter() {
        return ++counter;
    }

    @Override
    public void resetCounter() {
        counter=0;
    }
}
