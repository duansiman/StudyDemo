package com.devin.java.aware;

import com.devin.java.beans.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by devin on 2016/12/2.
 */
public abstract class UserManager {

    public abstract User createUser();

    public void process(){
        System.out.println(createUser());
    }
}