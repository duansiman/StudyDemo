package com.gson.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by devin on 2016/11/26.
 */
public class Tecacher {

    public Tecacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //指定序列化名字
    @SerializedName("t_name")
    public String name;

    @SerializedName("t_age")
    public int age;

}
