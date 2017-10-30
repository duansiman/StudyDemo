package com.epdc.java.concurrent.visibility;

import java.util.concurrent.CountDownLatch;

/**
 * Created by devin on 2017/8/8.
 */
public class CountDownLatchTest {

    static CountDownLatch startGate = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                System.out.println("start");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
            startGate.countDown();
        }).start();
        startGate.await();
        System.out.println("done");
    }

}
