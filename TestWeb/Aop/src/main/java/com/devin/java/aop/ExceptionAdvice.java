package com.devin.java.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by devin on 2017/2/4.
 */
public class ExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception e){
        System.out.println(e.getMessage());
    }

}
