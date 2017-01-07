package com.devin.java.task.async;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * Created by devin on 2017/1/3.
 */
@Configuration
public class BeanTools implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public  void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static <D> D getBean(Class<D> classname) {
        try{
            return applicationContext.getBean(classname);
        }catch(Exception e){
            return null;
        }
    }
}
