package com.devin.java.spel;

import java.util.List;

/**
 * Created by devin on 2017/1/12.
 */
public class User {

    private String name, sex;
    private List<String> interests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", interests=" + interests +
                '}';
    }
}
