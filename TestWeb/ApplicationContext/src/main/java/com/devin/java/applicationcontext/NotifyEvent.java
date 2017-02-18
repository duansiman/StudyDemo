package com.devin.java.applicationcontext;

import org.springframework.context.ApplicationEvent;

/**
 * Created by devin on 2017/2/3.
 */
public class NotifyEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NotifyEvent(Object source) {
        super(source);
    }
}
