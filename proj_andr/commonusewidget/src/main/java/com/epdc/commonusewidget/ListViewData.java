package com.epdc.commonusewidget;

/**
 * 当做listview item 数据源
 * Created by Epdc on 2015/8/22.
 */
public class ListViewData {

    private String name;
    private String sex;
    private int age;

    public ListViewData() {
    }

    public ListViewData(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
