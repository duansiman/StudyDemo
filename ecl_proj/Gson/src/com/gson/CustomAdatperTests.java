package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.User;

/**
 * Created by devin on 2016/11/26.
 */
public class CustomAdatperTests {

    public static void main(String[] args){
        Gson gson = new Gson();
        User user = new User("devin", "duan");
        String json = gson.toJson(user, User.class);
        System.out.println(json);

        User userFromJosn = gson.fromJson(json, User.class);
        System.out.println(userFromJosn.firstName+" " + userFromJosn.secondName);

    }

}
