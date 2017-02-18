package com.devin.java.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Created by devin on 2017/2/8.
 */
public class PerformanceInterceptor implements MethodInterceptor {

    private static Logger log = LoggerFactory.getLogger(PerformanceInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return methodInvocation.proceed();
        } finally {
            watch.stop();
            log.debug(watch.toString());
        }
    }
}
