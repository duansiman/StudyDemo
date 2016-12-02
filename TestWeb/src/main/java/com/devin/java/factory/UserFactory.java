package com.devin.java.factory;

/**
 * Created by devin on 2016/11/23.
 */
public class UserFactory {

    private static UserFactory userFactory = new UserFactory();

    private UserFactory(){}

    public static UserFactory createInstance(){
        return userFactory;
    }

    public String test(){
        return "hello static factory";
    }

}
