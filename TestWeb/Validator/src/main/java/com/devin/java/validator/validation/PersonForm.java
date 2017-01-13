package com.devin.java.validator.validation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by devin on 2017/1/12.
 */
public class PersonForm {

    @NotNull
    @Size(max = 64)
    private String name;

    @Min(0)
    private int age;

    public PersonForm(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
