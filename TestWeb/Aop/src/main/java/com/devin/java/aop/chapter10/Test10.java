package com.devin.java.aop.chapter10;

import com.devin.java.aop.entity.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/2/7.
 */
public class Test10 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-10.xml");
        Foo foo = context.getBean("foo", Foo.class);
        foo.method1();
        foo.method2();

        //测试aop-config中advisor
        foo.method2(20);


        //测试introduction的advice
//        ICounter mockTask = context.getBean("mockTask", ICounter.class);
//        System.out.println(mockTask.getCounter());
    }

}
