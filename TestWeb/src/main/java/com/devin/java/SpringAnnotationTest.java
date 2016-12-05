package com.devin.java;

import com.devin.java.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2016/12/5.
 */
public class SpringAnnotationTest {

    private User user;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-annotation.xml"});
        SpringAnnotationTest test = context.getBean("test", SpringAnnotationTest.class);
        System.out.println(test.user);
    }
}
