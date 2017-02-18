package com.devin.java.aop;

/**
 * Created by devin on 2017/2/4.
 */
public class UserService {

    public boolean login(String user, String pwd) throws Exception {
        System.out.println(user+":"+pwd);
        if ("devin".equals(user)) {
            throw new Exception("user is devin");
        }
        return true;
    }

}
