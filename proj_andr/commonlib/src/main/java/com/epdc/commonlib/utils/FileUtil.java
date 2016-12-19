package com.epdc.commonlib.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by epdc on 2016/5/21.
 */
public class FileUtil {

    private static String LOG_TAG = "epdc";
    public static final String DIR_MUSIC = "music";

    /**
     *  外部存储是否存在
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public static File getFileOfMusic(Context context, String filename) {

        File file = null;
        if (isExternalStorageWritable()) {
            File musicFile = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_MUSIC).getAbsolutePath());
            if (!musicFile.exists()) {
                if (!musicFile.mkdirs()) {
                    Log.e(LOG_TAG, "Storage music directory create fail.");
                    return file;
                }
            }
            file = new File(musicFile, filename);
        } else {
            File musicFile = new File(context.getFilesDir(), DIR_MUSIC);
            if (!musicFile.exists()) {
                if (!musicFile.mkdirs()) {
                    Log.e(LOG_TAG, "music directory create fail.");
                    return file;
                }
            }
            file = new File(musicFile, filename);
        }
        return file;
    }

    public static String getPathOfMusic(Context context, String filename) {

        File file = null;
        if (isExternalStorageWritable()) {
            File musicFile = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_MUSIC).getAbsolutePath());
            if (!musicFile.exists()) {
                if (!musicFile.mkdirs()) {
                    Log.e(LOG_TAG, "Storage music directory create fail.");
                    return null;
                }
            }
            file = new File(musicFile, filename);
        } else {
            File musicFile = new File(context.getFilesDir(), DIR_MUSIC);
            if (!musicFile.exists()) {
                if (!musicFile.mkdirs()) {
                    Log.e(LOG_TAG, "music directory create fail.");
                    return null;
                }
            }
            file = new File(musicFile, filename);
        }
        return file.getAbsolutePath();
    }

}
