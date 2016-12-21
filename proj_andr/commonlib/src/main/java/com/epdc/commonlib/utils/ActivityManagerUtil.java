package com.epdc.commonlib.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by epdc on 2016/6/29.
 */
public class ActivityManagerUtil {

    /**
     * 获取堆的可得空间大小，返回单位是MB
     * @param context
     * @return
     */
    public static int getHeapSize(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        return am.getLargeMemoryClass();
    }

}
