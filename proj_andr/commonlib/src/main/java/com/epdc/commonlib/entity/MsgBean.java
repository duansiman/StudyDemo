package com.epdc.commonlib.entity;

/**
 * Created by epdc on 2016/7/17.
 */
public class MsgBean {

    public Type type;
    public Object object;

    public MsgBean(Type type) {
        this.type = type;
    }

    public MsgBean(Type type, Object object) {
        this.type = type;
        this.object = object;
    }

    public static enum Type {
        REFRESH_SHARER

    }

}
