package com.devin.java.uncover;

import com.devin.java.helloworld.Greeting;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Created by devin on 2017/1/18.
 */
public class DefualtBeanFactoryTest {

    public static void main(String[] args) {

        DefaultListableBeanFactory defaultBeanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition abstractBeanDefinition = new RootBeanDefinition(Greeting.class);
        defaultBeanFactory.registerBeanDefinition("greeting", abstractBeanDefinition);

        BeanFactory beanFactory = defaultBeanFactory;

        Greeting greeting = beanFactory.getBean("greeting", Greeting.class);
        greeting.greeting();

    }

}
