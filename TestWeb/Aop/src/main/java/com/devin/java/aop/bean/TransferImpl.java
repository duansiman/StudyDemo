package com.devin.java.aop.bean;

/**
 * Created by devin on 2016/12/21.
 */
public class TransferImpl implements Transfer {
    @Override
    public void transfer() {
        System.out.println("transfer");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }


}
