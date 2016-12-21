package com.epdc.dailynote.listener;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by epdc on 2016/7/17.
 */
public class SimpleQueryListener<T> extends QueryListener<T> {

    @Override
    public void done(T t, BmobException e) {

    }
}
