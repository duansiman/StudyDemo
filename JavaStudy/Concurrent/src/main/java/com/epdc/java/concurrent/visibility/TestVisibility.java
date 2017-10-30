package com.epdc.java.concurrent.visibility;

/**
 * Created by devin on 2017/8/4.
 */
public class TestVisibility {

    private static boolean ready;
    private static int number;

    public static void main(String[] args) {
        new ReadThread().start();
        number=42;
        ready=true;
    }

    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while (!ready) {
                System.out.println("invalid");
                Thread.yield();
            }
            System.out.println(number);
        }
    }


}
