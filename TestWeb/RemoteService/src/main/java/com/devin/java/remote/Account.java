package com.devin.java.remote;

import java.io.Serializable;

/**
 * Created by devin on 2016/12/22.
 */
public class Account implements Serializable {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(String name) {
        this.name = name;
    }

    public Account() {
        this.name = name;
    }
}