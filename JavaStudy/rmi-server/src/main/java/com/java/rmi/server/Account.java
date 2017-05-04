package com.java.rmi.server;

import java.io.Serializable;

/**
 * Created by devin on 2017/4/26.
 */
public class Account implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
