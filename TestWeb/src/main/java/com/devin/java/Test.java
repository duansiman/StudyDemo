package com.devin.java;

import com.devin.java.beans.User;
import com.devin.java.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/16.
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/spring-parent.xml"});
        UserService userService = context.getBean("userService3", UserService.class);
        System.out.println(userService.getUserName());


        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        User user = new User("devin", '男');
        factory.registerSingleton("test", user);

        User test = context.getBean("test", User.class);
        System.out.println(test);
    }

}
