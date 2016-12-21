package com.devin.java.aop.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by devin on 2016/12/21.
 */
@Aspect
@Component
public class NotVeryUsefulAspect {

    @Pointcut("execution(* transfer(..))")// the pointcut expression
    private void anyOldTransfer() {}// the pointcut signature

    @Pointcut("execution(* hello(..))")
    private void hellopoint(){}

    @Before("anyOldTransfer()")
    private void beforeTransfer(){
        System.out.println("beforeTransfer");
    }

    @After("anyOldTransfer()")
    private void afterTransfer(){
        System.out.println("afterTransfer");
    }


    @Before("com.devin.java.aop.bean.NotVeryUsefulAspect.hellopoint()")
    private void beforeHello(){
        System.out.println("beforeHello");
    }
}
