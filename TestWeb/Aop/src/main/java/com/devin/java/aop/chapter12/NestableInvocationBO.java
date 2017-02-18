package com.devin.java.aop.chapter12;

import org.springframework.aop.framework.AopContext;

/**
 * Created by devin on 2017/2/7.
 */
public class NestableInvocationBO {

    public void method1(){
//        method2();
        NestableInvocationBO proxy = (NestableInvocationBO) AopContext.currentProxy();//获取当前对象的代理对象
        proxy.method2();
        System.out.println("method1 executed!");
    }

    public void method2(){
        System.out.println("method2 executed!");
    }

}
