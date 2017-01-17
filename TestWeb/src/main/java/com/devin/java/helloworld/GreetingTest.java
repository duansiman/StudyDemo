package com.devin.java.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by devin on 2017/1/17.
 */
public class GreetingTest {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-ioc.xml"});
//        Greeting greeting = context.getBean("greeting", Greeting.class);
//        greeting.greeting();

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring-ioc.xml"});
        Greeting greeting = context.getBean("greeting", Greeting.class);
        greeting.greeting();


//        ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"src/main/resources/spring/spring-ioc.xml"});
//        Greeting greeting = context.getBean("greeting", Greeting.class);
//        greeting.greeting();


    }

}
