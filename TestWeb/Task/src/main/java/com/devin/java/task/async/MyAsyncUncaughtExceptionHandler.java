package com.devin.java.task.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by devin on 2017/1/4.
 */
@Component
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        // handle exception
        System.out.println("handle exception");
        System.out.println(ex.getStackTrace());
    }
}
