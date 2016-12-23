package com.devin.java.email;

/**
 * Created by devin on 2016/12/23.
 */
public class Order {
    private Customer customer;
    private String orderNumber;

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
