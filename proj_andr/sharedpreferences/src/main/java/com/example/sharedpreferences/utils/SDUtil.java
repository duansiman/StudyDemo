package com.example.sharedpreferences.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

/**
 *  需要的权限
 *  <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

    genymotion sdcard路径 /mnt/shell/emulated/0

    可以通过/mnt/sdcard目录是否存在判断是否插入SD卡
 *
 * Created by Administrator on 2015/12/26.
 */
public class SDUtil {

    private static File sdcardDir;

    public static boolean isExistSD(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (sdcardDir == null) {
                sdcardDir = Environment.getExternalStorageDirectory();
            }
            return true;
        }
        return false;
    }

    public static void writeFiles(String fileName, String content){
        if (isExistSD() == false) {
            return;
        }
        try {
            File targetFile = new File(sdcardDir.getCanonicalPath(), fileName);
            RandomAccessFile raf = new RandomAccessFile(targetFile, "rw");

            //移动最后
            raf.seek(targetFile.length());
            raf.write(content.getBytes());
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFiles(String fileName){
        if (isExistSD() == false) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder("");
            FileInputStream fis = new FileInputStream(new File(sdcardDir.getCanonicalPath(), fileName));
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buff)) > 0) {
                sb.append(new String(buff, 0, hasRead));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
