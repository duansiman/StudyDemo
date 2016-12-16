package com.devin.java.springmvc.bean;

/**
 * Created by devin on 2016/12/6.
 */
public class User {

    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
