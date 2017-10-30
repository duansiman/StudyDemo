package com.epdc.java.concurrent.visibility;

/**
 * Created by devin on 2017/8/4.
 */
public class TestThreadLocal {

    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);


    private static class ReadThread extends Thread{

        public ReadThread(String name){
            setName(name);
        }

        @Override
        public void run() {
           Integer value = threadLocal.get();
           for (int i=value; i<=10; i++) {
               System.out.println(Thread.currentThread().getName() + ", " + i);
           }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ReadThread("thread"+i).start();
        }
    }

}
