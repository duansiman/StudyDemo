package com.devin.java.task.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * Created by devin on 2017/1/3.
 */
@Component
public class TaskAsync {

    @Async
    public void doSomething() {
        // this will be executed asynchronously
        System.out.println(1/0);
    }

    @Async
    public Future<String> returnSomething(int i) {
        // this will be executed asynchronously
        return new AsyncResult("hello" + i);
    }

}
