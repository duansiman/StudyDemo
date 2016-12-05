package com.devin.java.mvc;

import com.devin.java.beans.User;
import org.springframework.stereotype.Repository;

/**
 * Created by devin on 2016/12/5.
 */
@Repository
public class UserDao {

    private User user = new User("devin", '男');

    public User getUser(){
        return user;
    }

}
