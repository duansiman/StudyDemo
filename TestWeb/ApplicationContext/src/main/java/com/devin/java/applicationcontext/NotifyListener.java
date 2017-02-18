package com.devin.java.applicationcontext;

import org.springframework.context.ApplicationListener;

/**
 * Created by devin on 2017/2/3.
 */
public class NotifyListener implements ApplicationListener<NotifyEvent> {

    @Override
    public void onApplicationEvent(NotifyEvent event) {
        System.out.println("notify event");
    }
}
