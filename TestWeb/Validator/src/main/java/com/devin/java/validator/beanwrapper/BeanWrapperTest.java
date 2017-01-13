package com.devin.java.validator.beanwrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Created by devin on 2017/1/12.
 */
public class BeanWrapperTest {

    public static void main(String[] args) {
        BeanWrapper company = new BeanWrapperImpl(new Company());

        company.setPropertyValue("name", "silvrr");

        BeanWrapper jim = new BeanWrapperImpl(new Employee());

        jim.setPropertyValue("name", "jim");

        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        String name = (String) company.getPropertyValue("managingDirector.name");
        System.out.println(name);

    }

}
