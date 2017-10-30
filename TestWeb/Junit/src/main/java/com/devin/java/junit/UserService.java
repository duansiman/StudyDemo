package com.devin.java.junit;


/**
 * Created by devin on 2017/2/20.
 */
public interface UserService {

    User getUserByName(String name);

    boolean isUser(User user);

}
