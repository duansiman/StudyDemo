package com.devin.java;

import com.devin.java.beans.Foo;
import com.devin.java.factory.UserFactory;
import com.devin.java.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2016/11/22.
 */
public class SpringTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-beans.xml"});

        UserService userService = context.getBean("us", UserService.class);
        System.out.println(userService.getUserName());

        UserFactory userFactory = context.getBean("userFactory", UserFactory.class);
        System.out.println(userFactory.test());

        UserService userService2 = context.getBean("userService2", UserService.class);
        System.out.println(userService2.getUserName());

        Foo foo = context.getBean("foo", Foo.class);
        System.out.println(foo);

        Foo foo2 = context.getBean("foo2", Foo.class);
        System.out.println(foo2);

        Foo foo3 = context.getBean("foo3", Foo.class);
        System.out.println(foo3);
    }

}
