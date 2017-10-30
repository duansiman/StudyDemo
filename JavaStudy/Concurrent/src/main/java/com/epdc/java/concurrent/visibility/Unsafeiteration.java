package com.epdc.java.concurrent.visibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devin on 2017/8/8.
 */
public class Unsafeiteration {

    static List<Integer> lists = new ArrayList<>();
    static {
        lists.add(1);lists.add(2);lists.add(3);
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lists.remove(0);
        }).start();

//        for (int i = 0; i < lists.size(); i++) {
//            Thread.sleep(1000);
//            System.out.println(i + ", " + lists.get(i));
//        }
        for (Integer i :lists) {//java.util.ConcurrentModificationException
            Thread.sleep(1000);
            System.out.println(i);
        }
    }

}
