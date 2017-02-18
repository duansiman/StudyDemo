package com.devin.java.aop.entity;

/**
 * Created by devin on 2017/2/7.
 */

public class Foo {

    public void method1(){
        System.out.println("method1 execution");
    }

    public void method2(){
        System.out.println("method2 execution");
    }

    public void method2(String arg){
        System.out.println("method2 execution " + arg);
    }

    public void method2(int arg){
        System.out.println("method2 execution " + arg);
    }

    public void method2(TargetFoo arg){
        System.out.println("method2 execution " + arg);
    }

    public void error() throws Exception {
//        System.out.println(1/0);
        throw new Exception("error");
    }


    public String returnValue(){
        return "hello";
    }

    public String getPrice(String condition){
        return "100";
    }

}
