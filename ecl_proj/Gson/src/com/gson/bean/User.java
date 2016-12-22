package com.gson.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.gson.adapter.UserAdpater;

/**
 * Created by devin on 2016/11/26.
 */

@JsonAdapter(UserAdpater.class)//指定类型转换器
public class User {

    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String firstName;


    public String secondName;

}
