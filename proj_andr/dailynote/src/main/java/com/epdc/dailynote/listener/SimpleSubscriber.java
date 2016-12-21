package com.epdc.dailynote.listener;

import com.epdc.commonlib.listener.OnPresenterNotifyListener;
import com.epdc.commonlib.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;

/**
 * Created by epdc on 2016/7/17.
 */
public class SimpleSubscriber<T> extends Subscriber<T> {

    private OnPresenterNotifyListener listener;
    private int reqCode;

    public SimpleSubscriber(OnPresenterNotifyListener listener, int reqCode) {
        this.listener = listener;
        this.reqCode = reqCode;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {
        LogUtil.d("获取数据失败：" + throwable.getMessage());
        listener.onPresenterNotify(reqCode, OnPresenterNotifyListener.ERROR_SERVER, null);
    }

    @Override
    public void onNext(T t) {
        LogUtil.d("获取数据：" + t);
        Map<String, Object> data = new HashMap<>();
        data.put("data", t);
        listener.onPresenterNotify(reqCode, OnPresenterNotifyListener.RESULT_OK, data);
    }
}
