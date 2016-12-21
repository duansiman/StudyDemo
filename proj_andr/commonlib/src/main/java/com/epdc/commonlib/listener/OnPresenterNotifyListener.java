package com.epdc.commonlib.listener;

import java.util.Map;

/**
 * Created by epdc on 2016/7/5.
 */
public interface OnPresenterNotifyListener {

    int ERROR_NETWORK = -1;
    int ERROR_SERVER = -2;
    int RESULT_OK = 0;

    void onPresenterNotify(int reqCode, int resultCode, Map<String, Object> data);

}
