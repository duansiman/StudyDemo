package com.gson.bean;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

/**
 * Created by devin on 2016/11/26.
 */
public class Parent {

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Until(1.1)
    public String name;

    @Until(1.2)
    public int age;

}
