package com.devin.java.aop.chapter10;

import com.devin.java.aop.entity.Foo;
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

    @Pointcut("execution(public void *.method1())|| execution(public void *.method2())")
    public void pointcutName(){}

    @Pointcut("execution(* *(String))")
    public void pointcutName2(){}

    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return joinPoint.proceed();
        } finally {
            watch.stop();
            log.debug(watch.toString());
        }
    }

    @Around(value = "pointcutName2() && args(arg)")/*添加参数，args指定名字*/
    public Object performanceTrace2(ProceedingJoinPoint joinPoint, Object arg) throws Throwable {
        System.out.println(arg);
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return joinPoint.proceed(new Object[]{"hello"});/*不传参数，也会默认调用参数值*/
        } finally {
            watch.stop();
            log.debug(watch.toString());
        }
    }

    public static void main(String[] args) {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(new Foo());
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAspect(new PerformanceTraceAspect());
        Foo proxy = proxyFactory.getProxy();
        proxy.method1();
        proxy.method2();
        proxy.method2("args..");
    }

}
