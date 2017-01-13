package com.devin.java.validator.validation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/12.
 */
public class ValidationTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"validator.xml"});
        PersonForm personForm = context.getBean("person", PersonForm.class);
        System.out.println(personForm);
    }

}
