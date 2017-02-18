package com.devin.java.uncover;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/23.
 */
public class PostProcessorTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-uncover.xml");
        PostProcessorBean postProcessorBean = context.getBean("postProcessorBean", PostProcessorBean.class);
        System.out.println(postProcessorBean);

        DateBean dateBean = context.getBean("dateBean", DateBean.class);
        System.out.println(dateBean);
    }

}
