package com.epdc.dailynote.presenter;

import com.epdc.commonlib.listener.OnPresenterNotifyListener;

/**
 * Created by epdc on 2016/7/5.
 */
public abstract class BasePresenter {

    protected OnPresenterNotifyListener listener;

    public BasePresenter(OnPresenterNotifyListener listener) {
        this.listener = listener;
    }
}
