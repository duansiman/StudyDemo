package com.devin.java;

import com.devin.java.client.SimpleObject;
import com.devin.java.remote.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by devin on 2016/12/22.
 */
public class RMIMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rmi-servlet.xml");
        SimpleObject simpleObject = context.getBean("simpleObject", SimpleObject.class);
        simpleObject.insertAccount();
        List<Account> accounts = simpleObject.getAccounts();
        accounts.stream().forEach(account -> System.out.println(account.getName()));
    }

}
