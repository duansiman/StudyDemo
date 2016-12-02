package com.devin.java.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by devin on 2016/12/2.
 */
public class Container {

    private Properties properties;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Container{" +
                "properties=" + properties +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
