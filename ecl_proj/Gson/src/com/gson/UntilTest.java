package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.Parent;

/**
 * Created by devin on 2016/11/26.
 */
public class UntilTest {

    public static void main(String[] args){
        //转换大于指定版本的字段
        Gson gson = new GsonBuilder().setVersion(1.2).create();
        Parent c= new Parent("devin", 25);
        String json = gson.toJson(c, Parent.class);
        System.out.println(json);

        Parent tFromJosn = gson.fromJson(json, Parent.class);
        System.out.println(tFromJosn.name+" " + tFromJosn.age);

    }

}
