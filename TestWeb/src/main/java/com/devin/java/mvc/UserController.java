package com.devin.java.mvc;

import com.devin.java.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Created by devin on 2016/12/5.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void login(String name) {
        if (userService.login(new User(name, '男'))) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        UserController controller = context.getBean(UserController.class);
        controller.login("devin");
    }
}
