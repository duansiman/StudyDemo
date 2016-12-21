package com.epdc.weibo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/12/20.
 */
public class ToastUtil {

    private static Toast toast;
    private static boolean isOpen = true;

    public static void show(Context context, String msg){
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }

    public static void showTest(Context context, String msg){
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        if (isOpen) {
            toast.show();
        }
    }

}
