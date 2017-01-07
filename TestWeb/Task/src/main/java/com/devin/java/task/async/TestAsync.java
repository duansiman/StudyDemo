package com.devin.java.task.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * Created by devin on 2017/1/3.
 */
@SpringBootApplication  //boot只扫描当前包下的
@EnableAsync
public class TestAsync extends AsyncConfigurerSupport {

    public static void main(String[] args) {
        SpringApplication.run(TestAsync.class, args);
        TaskAsync taskAsync = BeanTools.getBean(TaskAsync.class);
        taskAsync.doSomething();
        System.out.println("hello async");
        Future<String> future = taskAsync.returnSomething(10);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return BeanTools.getBean(MyAsyncUncaughtExceptionHandler.class);
    }
}
