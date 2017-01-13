package com.devin.java.validator.format;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by devin on 2017/1/12.
 */
public class FormatTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"validator.xml"});
        MyModel myModel = context.getBean("myModel", MyModel.class);
        System.out.println(myModel.getDate());
    }
}
