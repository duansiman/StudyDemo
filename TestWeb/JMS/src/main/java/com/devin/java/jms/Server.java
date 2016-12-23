package com.devin.java.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2016/12/23.
 */

public class Server {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext(new String[]{"server.xml"});
    }

}
