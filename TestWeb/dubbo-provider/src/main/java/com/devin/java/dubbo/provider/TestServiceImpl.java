package com.devin.java.dubbo.provider;

/**
 * Created by devin on 2017/5/5.
 */
public class TestServiceImpl implements TestService {
    @Override
    public String getName() {
        return "dubbo provider";
    }

}
