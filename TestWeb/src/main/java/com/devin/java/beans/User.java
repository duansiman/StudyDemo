package com.devin.java.beans;

/**
 * Created by devin on 2016/12/2.
 */
public class User {
    private String username;
    private char sex;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", sex=" + sex +
                '}';
    }
}
