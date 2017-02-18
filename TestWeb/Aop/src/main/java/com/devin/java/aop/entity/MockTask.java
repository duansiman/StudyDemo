package com.devin.java.aop.entity;

/**
 * Created by devin on 2017/2/6.
 */
public class MockTask implements ITask {

    private int count;

    @Override
    public void task() {
        System.out.println("MockTask" + count++);
    }
}
