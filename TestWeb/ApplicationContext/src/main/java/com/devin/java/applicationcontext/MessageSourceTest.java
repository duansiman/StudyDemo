package com.devin.java.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by devin on 2017/2/3.
 */
public class MessageSourceTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        String message = context.getMessage("hello", null, Locale.US);
        System.out.println(message);
    }

}
