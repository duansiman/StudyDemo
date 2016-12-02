package com.devin.java.service;

/**
 * Created by devin on 2016/12/2.
 */
public class UserProxyService {

    private UserService target;

    public void setTarget(UserService target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return target.getUserName();
    }
}
