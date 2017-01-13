package com.devin.java.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/12.
 */
public class StuTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spel.xml"});
        Student stu = context.getBean("stu", Student.class);
        System.out.println(stu);
    }

}
