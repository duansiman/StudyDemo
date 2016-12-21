package com.example.sharedpreferences.utils;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Administrator on 2015/12/26.
 */
public class FilesUtil {
    //文件路径：/data/data/<package name>/files
    /**
     *
     * @param context
     * @param fileName
     * @param mode
     *      Context.MODE_PRIVATE 只能被当前程序读写
     *      Context.MODE_APPEND 可以向文件追加内容
     *      Context.MODE_WORLD_READABLE 可被其他应用程序读，但不能写。
     *      Context.MODE_WORLD_WRITEABLE 可被其他应用程序读写。
     */
    public static void writeFiles(Context context, String fileName, int mode, String content){
        FileOutputStream fos = null;
        PrintStream pw = null;
        try {
            fos = context.openFileOutput(fileName, mode);
            pw = new PrintStream(fos);
            pw.print(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                    fos = null;
                    if (pw != null) {
                        pw.close();
                        pw = null;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readFiles(Context context, String fileName){
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder("");
        try {
            fis = context.openFileInput(fileName);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buff)) > 0) {
                sb.append(new String(buff, 0, hasRead));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 在应用程序数据文件夹下（/data/data/<package name>），创建或获取fileName对应的子目录
     * @param context
     * @param fileName
     * @param mode
     * @return
     */
    public static File getDir(Context context, String fileName, int mode){
       return context.getDir(fileName, mode);
    }

    /**
     * 获取数据文件夹的绝对路径
     * @param context
     * @return
     */
    public static File getFilesDir(Context context){
        return context.getFilesDir();
    }

    /**
     * 获取数据文件夹下全部文件
     * @param context
     * @return
     */
    public static String[] fileList(Context context){
        return context.fileList();
    }

    /**
     * 删除文件
     * @param context
     * @param fileName
     */
    public static void deleteFile(Context context, String fileName){
        context.deleteFile(fileName);
    }


    /**
     * 获取缓存目录
     * @param context
     * @return
     */
    public static File getCacheDir(Context context){
        return context.getCacheDir();
    }





}
