package com.gson.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by devin on 2016/11/26.
 */
public class Student {

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //是否序列化
    @Expose(serialize = false)
    public String name;

    //是否反序列化
    @Expose(deserialize = false)
    public int age;

}
