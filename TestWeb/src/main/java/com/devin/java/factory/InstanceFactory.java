package com.devin.java.factory;

import com.devin.java.service.UserService;
import com.devin.java.service.UserServiceImpl;

/**
 * Created by devin on 2016/12/1.
 */
public class InstanceFactory {

    public UserService createService(){
        return new UserServiceImpl();
    }

}
