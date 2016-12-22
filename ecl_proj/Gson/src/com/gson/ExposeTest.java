package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.Student;

/**
 * Created by devin on 2016/11/26.
 */
public class ExposeTest {

    public static void main(String[] args){

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Student student = new Student("devin", 23);
        String json = gson.toJson(student, Student.class);
        System.out.println(json);

        Student stuFromJson = gson.fromJson(json, Student.class);
        System.out.println(stuFromJson.name + ", " + stuFromJson.age);
    }

}
