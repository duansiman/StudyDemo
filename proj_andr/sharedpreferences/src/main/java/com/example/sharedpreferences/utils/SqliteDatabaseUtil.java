package com.example.sharedpreferences.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

/**
 *  当使用CursorAdapter适配器，要求表的主键列的列名为 _id
 *
 *  事务：
 *       sqLiteDatabase.beginTransaction();
         try{

             //执行操作
             ...
             //设置事务成功，否则回滚事务
             sqLiteDatabase.setTransactionSuccessful();
         } finally {
            sqLiteDatabase.endTransaction();
         }

    sqlite3工具
        -> sqlite3 数据库文件路径
        -> .databases 查看当前数据库
        -> .tables 查看数据表
        -> .help 查看命令

    类型：Sqlite内部支持 null, integer, real, text, blob类型，其实其他数据库类型，例如MySQL
         sqlite允许把各种数据类型的数据保存到任何类型字段中，于是创建表格时，定义字段类型可以省略。
         但定义为integer primary key字段只能存储64位整数。
 *
 * Created by Administrator on 2015/12/26.
 */
public class SqliteDatabaseUtil {

    private static String DATEBASE_NAME = "sqlite.db";
    private static SQLiteDatabase sqLiteDatabase;

    private static void openOrCreate(Context context){

        try {
            if (sqLiteDatabase == null) {
                sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir().getCanonicalPath() + "/" + DATEBASE_NAME, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void execlSQL(Context context, String sql, Object[] bindArgs){
        openOrCreate(context);
        sqLiteDatabase.execSQL(sql, bindArgs);
    }

    /**
     *
     * @param context
     * @param table
     * @param nullColumnHack 当values没有值，生效。
     * @param values
     */
    public static void insert(Context context, String table, String nullColumnHack, ContentValues values){
        openOrCreate(context);
        sqLiteDatabase.insert(table, nullColumnHack, values);
    }

    public static void update(Context context, String table, ContentValues values, String whereClause, String[] whereArgs){
        openOrCreate(context);
        sqLiteDatabase.update(table, values, whereClause, whereArgs);
    }

    public static void delete(Context context,String table, String whereClause, String[] whereArgs){
        openOrCreate(context);
        sqLiteDatabase.delete(table, whereClause, whereArgs);
    }

    /**
     *
     * @param context
     * @param distinct
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @param groupBy
     * @param having
     * @param orderBy
     * @param limit 例如："m, n" 表示 n是指从第m+1条开始，取n条
     */
    public static void query(Context context,boolean distinct, String table, String[] columns,
                             String selection, String[] selectionArgs, String groupBy,
                             String having, String orderBy, String limit){
        openOrCreate(context);
        sqLiteDatabase.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

    public static void rawQuery(Context context,String sql, String[] selectionArgs){
        openOrCreate(context);
        sqLiteDatabase.rawQuery(sql, selectionArgs);

    }

}
