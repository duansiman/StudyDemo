package com.epdc.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *  自定义ContentProvider
 * Created by Epdc on 2015/9/15.
 */
public class CustomContentProvider extends ContentProvider {

    //uri转换匹配器，便于处理
    private static UriMatcher uriMatcher;
    //uri 有两部分组成 authority 和 path。authority相当于网址中域名，path相当于网址中路径
    private static final String AUTHORITY = "com.epdc.commonusekownledge";
    private static final int CITIES = 1;
    private static final int CITY_CODE = 2;
    private static final int CITY_NAME = 3;
    private static final int CITIES_IN_PROVINCE = 4;
    private SQLiteDatabase database;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // content://cn.eoe.regioncontentprovider/cities
        uriMatcher.addURI(AUTHORITY, "cities", CITIES);
        //# 匹配任何数字，  * 匹配任何字符
        //  content://cn.eoe.regioncontentprovider/code/024
        uriMatcher.addURI(AUTHORITY, "code/#", CITY_CODE);
        //  content://cn.eoe.regioncontentprovider/name/北京
        uriMatcher.addURI(AUTHORITY, "name/*", CITY_NAME);
        //  content://cn.eoe.regioncontentprovider/cities_in_province/辽宁
        uriMatcher.addURI(AUTHORITY, "cities_in_province/*", CITIES_IN_PROVINCE);
    }

    @Override
    public boolean onCreate() {
        try
        {
            String databaseFilename = "/sdcard/region.db";
            if (!(new File(databaseFilename)).exists())
            {
                InputStream is = getContext().getResources().getAssets()
                        .open("region.db");
                FileOutputStream fos = new FileOutputStream(databaseFilename);
                byte[] buffer = new byte[8192];
                int count = 0;
                while ((count = is.read(buffer)) > 0)
                {
                    fos.write(buffer, 0, count);
                }

                fos.close();
                is.close();
            }
            database = SQLiteDatabase.openOrCreateDatabase(
                    databaseFilename, null);

        }
        catch (Exception e)
        {
            Log.d("error", e.getMessage());
            database = null;
        }
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Cursor cursor = null;

        //把uri转换对应的代码
        switch (uriMatcher.match(uri))
        {
            case CITIES:

                //第一个参数表名
                cursor = database.query("v_cities_province", projection,
                        selection, selectionArgs, null, null, sortOrder);
                break;
            case CITY_CODE:
                String cityCode = uri.getPathSegments().get(1);
                if (selection == null)
                    selection = "city_code='" + cityCode + "'";
                else
                    selection += " and (city_code='" + cityCode + "')";
                cursor = database.query("t_cities", projection, selection,
                        selectionArgs, null, null, sortOrder);

                break;
            case CITY_NAME:
                String cityName = uri.getPathSegments().get(1);
                if (selection == null)
                    selection = "city_name='" + cityName + "'";
                else
                    selection += " and (city_name='" + cityName + "')";
                cursor = database.query("t_cities", projection, selection,
                        selectionArgs, null, null, sortOrder);

                break;
            case CITIES_IN_PROVINCE:
                String provinceName = uri.getPathSegments().get(1);
                if (selection == null)
                    selection = "province_name='" + provinceName + "'";
                else
                    selection += " and (province_name='" + provinceName + "')";
                cursor = database.query("v_cities_province", projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException("<" + uri + ">格式不正确.");
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

}
