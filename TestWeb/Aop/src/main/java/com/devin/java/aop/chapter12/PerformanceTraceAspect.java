package com.devin.java.aop.chapter12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.util.StopWatch;

/**
 * Created by devin on 2017/2/7.
 */
@Aspect
public class PerformanceTraceAspect {

    private static Logger log = LoggerFactory.getLogger(PerformanceTraceAspect.class);

    @Pointcut("execution(public void *.method1())")/*方法执行类型*/
    public void method1(){}

    @Pointcut("execution(public void *.method2())")
    public void method2(){}

    @Pointcut("method1()||method2()")/*Pointcut 运算*/
    public void compositePointcut(){}

    @Around("compositePointcut()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();

        try {
            watch.start();
            return joinPoint.proceed();
        }finally {
            watch.stop();
            log.debug(joinPoint.getSignature().getName()+" >>>> "+watch.toString());
        }
    }

    public static void main(String[] args) {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(new NestableInvocationBO());
        proxyFactory.setProxyTargetClass(true);//基于类代理
        proxyFactory.setExposeProxy(true);//暴露代理对象
        proxyFactory.addAspect(new PerformanceTraceAspect());
        NestableInvocationBO proxy = proxyFactory.getProxy();
        proxy.method1();
        proxy.method2();
    }

}
