package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.Tecacher;

/**
 * Created by devin on 2016/11/26.
 */
public class SerializedNameTest {

    public static void main(String[] args){

        Gson gson = new Gson();
        Tecacher t = new Tecacher("devin", 25);
        String json = gson.toJson(t, Tecacher.class);
        System.out.println(json);

        Tecacher tFromJosn = gson.fromJson(json, Tecacher.class);
        System.out.println(tFromJosn.name+" " + tFromJosn.age);

    }

}
