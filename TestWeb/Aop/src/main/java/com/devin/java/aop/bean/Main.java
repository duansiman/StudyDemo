package com.devin.java.aop.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by devin on 2016/12/21.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
        Transfer transfer =  context.getBean("transfer", Transfer.class);
        transfer.transfer();
        transfer.hello();
    }

}
