package com.devin.java.beans;

/**
 * Created by devin on 2016/12/1.
 */
public class Baz {

    private String name;

    @Override
    public String toString() {
        return "baz " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
