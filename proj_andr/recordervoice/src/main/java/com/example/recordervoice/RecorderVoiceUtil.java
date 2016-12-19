package com.example.recordervoice;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by epdc on 2016/5/19.
 * 录音工具类
 */
public class RecorderVoiceUtil {

    public static String TAG = "epdc";

    private static MediaRecorder mediaRecorder;
    private static OnRecorderListener mListener;
    private static String mOutputPath;
    private static int mMaxDurationMs;
    private static long startRecorderTime, endRecorderTime;

    /**
     * 开始录音
     * @param outputPath
     * @param maxDurationMs 录音最大时间
     * @param listener
     */
    public static void startRecorder(String outputPath, final int maxDurationMs, final OnRecorderListener listener) {

        mListener = listener;
        mOutputPath = outputPath;
        mMaxDurationMs = maxDurationMs;

        mediaRecorder = new MediaRecorder();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

        if (mMaxDurationMs <= 0) {
            mediaRecorder.setMaxDuration(mMaxDurationMs);
        }
        mediaRecorder.setOutputFile(mOutputPath);
        //第一次获取为0
        mediaRecorder.getMaxAmplitude();
        mediaRecorder.setOnInfoListener(new MediaRecorder.OnInfoListener() {
            @Override
            public void onInfo(MediaRecorder mr, int what, int extra) {
                if (what == MediaRecorder.MEDIA_RECORDER_INFO_MAX_DURATION_REACHED) {
                    mListener.onReachMax(mOutputPath, mMaxDurationMs);
                    stopRecorder();
                }
            }
        });

        mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
            @Override
            public void onError(MediaRecorder mr, int what, int extra) {
                Log.e(TAG, "recorder error");
                mListener.onError();
            }
        });

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "recorder io error");
            mListener.onError();
            clear();
        }

        try {
            mediaRecorder.start();
            startRecorderTime = System.currentTimeMillis();
            Log.i(TAG, "recorder start");
            mListener.onStart();
        } catch (RuntimeException e) {
            e.printStackTrace();
            //没有录音权限报错,6.0以下版本应该是这样
            Log.e(TAG, "recorder permission error");
            mListener.onPermissionError();
        }
    }

    public static int getMaxAmplitude(){
        return mediaRecorder.getMaxAmplitude();
    }

    /**
     * 停止录音
     */
    public static void stopRecorder() {
        clear();
        endRecorderTime = System.currentTimeMillis();
        Log.i(TAG, "recorder success");
        Log.i(TAG, "recorder voiceLength:"+(endRecorderTime - startRecorderTime));
        mListener.onSuccess(mOutputPath, (endRecorderTime - startRecorderTime));
    }

    /**
     * 取消录音
     */
    public static void cancelRecorder() {
        clear();
        File file = new File(mOutputPath);
        file.delete();
        Log.w(TAG, "recorder cancel");
        mListener.onCancel();
    }

    /**
     * 释放资源
     */
    private static void clear(){
        //start后，一秒内stop录音会报RuntimeException
        try {
            mediaRecorder.stop();
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        mediaRecorder.release();
        mediaRecorder = null;
    }


    public interface OnRecorderListener {
        void onReachMax(String outputPath, int maxDurationMs);

        void onError();

        void onPermissionError();

        void onStart();

        void onCancel();

        void onSuccess(String outputPath, long voiceLength);
    }

    public static class SimpleRecorderListener implements OnRecorderListener {

        @Override
        public void onReachMax(String outputPath, int maxDurationMs) {

        }

        @Override
        public void onError() {

        }

        @Override
        public void onPermissionError() {

        }

        @Override
        public void onStart() {

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onSuccess(String outputPath, long voiceLength) {

        }
    }

}
