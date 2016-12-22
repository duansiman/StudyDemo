package com.gson;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Created by devin on 2016/11/26.
 */
public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();

        Integer integer = gson.fromJson("5", int.class);
        System.out.println(integer);

        Double d = gson.fromJson("5.5", Double.class);
        System.out.println(d);

        Number number = gson.fromJson("5.6", Number.class);
        System.out.println(number);

        Date date = new Date();
        String s = gson.toJson(date, Date.class);
        System.out.println(s);

        Date dateFromJson = gson.fromJson("'2016-11-26 14:23:00'", Date.class);
        System.out.println(dateFromJson.toLocaleString());
    }

}

