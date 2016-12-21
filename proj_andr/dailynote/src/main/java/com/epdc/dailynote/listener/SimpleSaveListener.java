package com.epdc.dailynote.listener;

import com.epdc.commonlib.listener.OnPresenterNotifyListener;
import com.epdc.commonlib.utils.LogUtil;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by epdc on 2016/7/17.
 */
public class SimpleSaveListener extends SaveListener<String> {

    private OnPresenterNotifyListener listener;
    private int reqCode;

    public SimpleSaveListener(OnPresenterNotifyListener listener, int reqCode) {
        this.listener = listener;
        this.reqCode = reqCode;
    }

    @Override
    public void done(String s, BmobException e) {
        if (e == null) {
            LogUtil.d("保存成功");
            listener.onPresenterNotify(reqCode, OnPresenterNotifyListener.RESULT_OK, null);
        } else {
            LogUtil.d("保存失败", e);
            listener.onPresenterNotify(reqCode, OnPresenterNotifyListener.ERROR_SERVER, null);
        }
    }
}
