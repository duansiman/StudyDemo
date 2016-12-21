package com.example.recordervoice;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

import java.util.TimerTask;

/**
 * Created by epdc on 2016/5/21.
 */
public class RecorderTask extends TimerTask {

    public static String TAG = "epdc";
    
    private final ImageView imageSay;
    private Activity activity;
    private boolean isCancel;

    public RecorderTask(Activity activity, ImageView imageSay) {
        this.activity = activity;
        this.imageSay = imageSay;
    }

    @Override
    public void run() {

        if (!isCancel){
            int maxAmplitude = RecorderVoiceUtil.getMaxAmplitude();
            Log.i(TAG, "maxAmplitude为:" + maxAmplitude);
            if (maxAmplitude > 1) {
                final double db = 20 * Math.log10(maxAmplitude);
                Log.i(TAG, "音量为:" + db);
                Log.i(TAG, "imageSay:" + imageSay+", isCancel"+isCancel);
                if (imageSay != null && !isCancel) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (db <= 15) {
                                imageSay.setImageResource(R.drawable.mic_1);
                            } else if (db > 15 && db <= 30) {
                                imageSay.setImageResource(R.drawable.mic_2);
                            } else if (db > 30 && db <= 45) {
                                imageSay.setImageResource(R.drawable.mic_3);
                            } else if (db > 45 && db <= 60) {
                                imageSay.setImageResource(R.drawable.mic_4);
                            } else if (db > 60 && db <= 75) {
                                imageSay.setImageResource(R.drawable.mic_5);
                            } else if (db > 75) {
                                imageSay.setImageResource(R.drawable.mic_6);
                            }
                        }
                    });

                }
            }
        }

    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }
}
