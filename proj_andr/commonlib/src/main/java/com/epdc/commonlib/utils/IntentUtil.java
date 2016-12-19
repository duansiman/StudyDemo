package com.epdc.commonlib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import java.io.Serializable;

/**
 * Created by epdc on 2016/7/17.
 */
public class IntentUtil {

    public static void startActivity(Context context, Class clz){
        Intent intent = new Intent(context, clz);
        context.startActivity(intent);
    }

    public static <T extends Serializable> void startActivity(Context context, Class clz, String key, T t){
        Intent intent = new Intent(context, clz);
        intent.putExtra(key, t);
        context.startActivity(intent);
    }

    public static void bindServiceOfAutoCreate(Context context, Class clz, ServiceConnection mConnection){
        Intent intent = new Intent(context, clz);
        context.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

}
