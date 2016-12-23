package com.devin.java.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2016/12/23.
 */
public class SendEmail {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("mail-servlet.xml");
        OrderManager orderManager = context.getBean("orderManager", OrderManager.class);

        Customer customer = new Customer();
        customer.setEmailAddress("835804205@qq.com");
        customer.setFirstName("Devin");
        customer.setLastName("Duan");

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderNumber("0001");

        orderManager.placeOrder(order);

    }

}
