package com.devin.java.aop.introduction;

import com.devin.java.aop.entity.ITask;
import com.devin.java.aop.entity.ICounter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/2/6.
 */
public class IntroductionProxyFactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmvc-servlet.xml");

        ITask task1 = context.getBean("introducedTask", ITask.class);
        ITask task2 = context.getBean("introducedTask", ITask.class);

        task1.task();
        task1.task();
        task2.task();

        ICounter counter1 = context.getBean("introducedTask", ICounter.class);
        ICounter counter2 = context.getBean("introducedTask", ICounter.class);

        System.out.println(counter1.getCounter());
        System.out.println(counter1.getCounter());
        System.out.println(counter2.getCounter());

    }

}
