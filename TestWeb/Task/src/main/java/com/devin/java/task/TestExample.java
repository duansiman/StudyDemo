package com.devin.java.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/3.
 */
public class TestExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task-servlet.xml");
        TaskExecutorExample example = context.getBean("taskExecutorExample", TaskExecutorExample.class);
        example.printMessages();
    }

}
