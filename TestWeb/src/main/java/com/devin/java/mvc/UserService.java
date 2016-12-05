package com.devin.java.mvc;

import com.devin.java.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by devin on 2016/12/5.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(User user) {
        if (userDao.getUser().equals(user)) {
            return true;
        }
        return false;
    }

}
