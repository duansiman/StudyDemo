package com.example.sharedpreferences.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 *  SharedPreferences 用于保存少量数据，并且这些数据类型都是基本数据类型。
 * Created by Administrator on 2015/12/26.
 */
public class SharedPrefUtil {

    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor;
    private static Context context;

    private static void getInstance(Context context){
        if (sharedPref != null && editor != null) {
            return;
        }
        //第一个参数 取得名字   第二个参数 指定数据模式
        //不存在，创建sharedPref.xml文件，路径/data/data/<package name>/shared_prefs
        //MODE_PRIVATE 表示私有，其他应该不能读取。
        //下面两种模式，不推荐使用，容易导致安全漏洞
        //MODE_WORLD_READABLE 可被其他应用程序读，但不能写。
        //MODE_WORLD_WRITEABLE 可被其他应用程序读写。
        sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        //得到指定包名对应程序得Context
        /*try {
            Context otherContext = context.createPackageContext("com.epdc.test", Context.CONTEXT_IGNORE_SECURITY);

            //得到其他应用程序的sharedpreferences
            //和前面得操作一样
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public static void putBoolean(Context context, String key, boolean value){
        getInstance(context);
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putFloat(Context context, String key, float value){
        getInstance(context);
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void putInt(Context context, String key, int value){
        getInstance(context);
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putLong(Context context, String key, long value){
        getInstance(context);
        editor.putLong(key, value);
        editor.commit();
    }

    public static void putString(Context context, String key, String value){
        getInstance(context);
        editor.putString(key, value);
        editor.commit();
    }

    public static void putStringSet(Context context, String key, Set<String> value){
        getInstance(context);
        editor.putStringSet(key, value);
        editor.commit();
    }

    public static void clear(Context context){
        getInstance(context);
        editor.clear();
        editor.commit();
    }
    public static float getFloat(Context context, String key, float defValue){
        getInstance(context);
        return sharedPref.getFloat(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue){
        getInstance(context);
        return sharedPref.getInt(key, defValue);
    }

    public static long getLong(Context context, String key, long defValue){
        getInstance(context);
        return sharedPref.getLong(key, defValue);
    }

    public static String getString(Context context, String key, String defValue){
        getInstance(context);
        return sharedPref.getString(key, defValue);
    }

    public static Set<String> getStringSet(Context context, String key, Set<String> defValue){
        getInstance(context);
        return sharedPref.getStringSet(key, defValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue){
        getInstance(context);
        return sharedPref.getBoolean(key, defValue);
    }

    public static Map getAll(Context context){
        getInstance(context);
        return sharedPref.getAll();
    }
}
