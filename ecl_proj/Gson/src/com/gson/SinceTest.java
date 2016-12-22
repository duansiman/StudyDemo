package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.Child;

/**
 * Created by devin on 2016/11/26.
 */
public class SinceTest {

    public static void main(String[] args){
        //不会转换大于指定版本的字段
        Gson gson = new GsonBuilder().setVersion(1.0).create();
        Child c= new Child("devin", 25);
        String json = gson.toJson(c, Child.class);
        System.out.println(json);

        Child tFromJosn = gson.fromJson(json, Child.class);
        System.out.println(tFromJosn.name+" " + tFromJosn.age);

    }

}
