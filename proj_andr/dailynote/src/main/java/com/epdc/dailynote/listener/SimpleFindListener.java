package com.epdc.dailynote.listener;

import com.epdc.commonlib.listener.OnPresenterNotifyListener;
import com.epdc.commonlib.utils.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by epdc on 2016/7/5.
 */
public class SimpleFindListener<T> extends FindListener<T> {

    private OnPresenterNotifyListener listener;
    private int reqCode;

    public SimpleFindListener(OnPresenterNotifyListener listener, int reqCode) {
        this.listener = listener;
        this.reqCode = reqCode;
    }

    @Override
    public void done(List<T> list, BmobException e) {
        if (e == null) {
            LogUtil.d("获取数据大小：" + list.size());
            Map<String, Object> data = new HashMap<>();
            data.put("data", list);
            listener.onPresenterNotify(reqCode, OnPresenterNotifyListener.RESULT_OK, data);
        } else {
            LogUtil.d("获取数据失败：" + e.getMessage());
            listener.onPresenterNotify(reqCode, OnPresenterNotifyListener.ERROR_SERVER, null);
        }
    }
}
