package com.devin.java.beans;

import org.springframework.beans.factory.annotation.Required;

import java.util.Objects;

/**
 * Created by devin on 2016/12/2.
 */
public class User {
    private String username;
    private char sex;

    public User() {
    }

    public User(String username, char sex) {
        this.username = username;
        this.sex = sex;
    }

    @Required
    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return username.equals(user.username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", sex=" + sex +
                '}';
    }
}
