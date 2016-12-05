package com.devin.java.beans;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by devin on 2016/12/5.
 */
public class TestAware implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }
}
