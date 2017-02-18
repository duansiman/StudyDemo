package com.devin.java.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/2/3.
 */
public class EventTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        context.publishEvent(new NotifyEvent(new Object()));
    }

}
