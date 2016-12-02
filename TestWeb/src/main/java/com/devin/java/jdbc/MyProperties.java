package com.devin.java.jdbc;

import java.util.Properties;

/**
 * Created by devin on 2016/12/2.
 */
public class MyProperties {

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "properties=" + properties +
                '}';
    }
}
