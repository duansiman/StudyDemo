package com.example.sharedpreferences.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * 这两个方法在获取数据库实例，如果数据库不存在，自动生成数据库调用onCreate方法
 *
 * getReadableDatabase()
 *      先以读写打开数据库，如果磁盘不够，再用读打开数据库。
 * getWritableDatabase()
 *      磁盘空间不够时，就会出错
 *
 * Created by Administrator on 2015/12/26.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "sqlite.db";
    public final static int DB_VERSION = 1;//必须大于0

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MySQLiteOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * 初次生成数据库时，调用该方法
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    /**
     * 当数据库版本变大时，调用该方法
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
