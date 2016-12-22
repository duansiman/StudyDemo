package com.gson.bean;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;

/**
 * Created by devin on 2016/11/26.
 */
public class Child {

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Since(1.0)
    public String name;

    @Since(1.1)
    public int age;

}
