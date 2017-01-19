package com.devin.java.uncover;

        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/19.
 */
public class FactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-uncover.xml");
        NextDayDateDisplayer nextDay = context.getBean("nextDay", NextDayDateDisplayer.class);
        System.out.println(nextDay.getDateOfNextDay());
    }
}
