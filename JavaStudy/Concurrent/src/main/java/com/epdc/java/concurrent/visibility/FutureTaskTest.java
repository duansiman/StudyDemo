package com.epdc.java.concurrent.visibility;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by devin on 2017/8/10.
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("start");
                Thread.sleep(100);
                return 12;
            }
        });

        new Thread(task).start();
        Integer result = task.get();
        System.out.println(result);

    }

}
