package com.epdc.java.concurrent.visibility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by devin on 2017/8/8.
 */
public class CopyOnWriteArrayListTest {

    static CopyOnWriteArrayList<Integer> lists = new CopyOnWriteArrayList<>();
    static {
        lists.add(1);lists.add(2);lists.add(3);
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lists.remove(0);
            System.out.println("remove");
        }).start();

        for (Integer i :lists) {
            System.out.println("each");
            Thread.sleep(1000);
            System.out.println(i);
        }

        System.out.println();
        for (Integer i :lists) {
            System.out.println(i);
        }
    }

}
