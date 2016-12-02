package com.devin.java;

import com.devin.java.aware.CommandManager;
import com.devin.java.aware.UserManager;
import com.devin.java.beans.Container;
import com.devin.java.beans.Foo;
import com.devin.java.beans.Idref;
import com.devin.java.factory.UserFactory;
import com.devin.java.jdbc.MyDataSource;
import com.devin.java.jdbc.MyProperties;
import com.devin.java.service.UserProxyService;
import com.devin.java.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2016/11/22.
 */
public class SpringTest {

    public static void main(String[] args){
        ApplicationContext parent = new ClassPathXmlApplicationContext(new String[]{"spring/spring-parent.xml"});//父容器
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-beans.xml"}, parent);//子容器

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

        MyDataSource dataSource = context.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);

        MyProperties properties = context.getBean("prop", MyProperties.class);
        System.out.println(properties);

        Idref idref = context.getBean("idref", Idref.class);
        System.out.println(idref);

        UserProxyService proxyService = context.getBean("userService3", UserProxyService.class);
        System.out.println(proxyService);

        Foo foo4 = context.getBean("foo4", Foo.class);
        System.out.println(foo4);

        Container container = context.getBean("container", Container.class);
        System.out.println(container);

        Container child = context.getBean("child", Container.class);
        System.out.println(child);

        MyDataSource dataSource2 = context.getBean("dataSource2", MyDataSource.class);
        System.out.println(dataSource2);

        Foo foo5 = context.getBean("foo5", Foo.class);
        System.out.println(foo5);

        Foo foo6 = context.getBean("foo6", Foo.class);
        System.out.println(foo6);

        Foo foo66 = context.getBean("foo6", Foo.class);
        System.out.println(foo66==foo6);

        CommandManager commandManager = context.getBean("manager", CommandManager.class);
        commandManager.createCommand();
        commandManager.createCommand();

        UserManager userManager = context.getBean("userManager", UserManager.class);
        userManager.process();

    }

}

