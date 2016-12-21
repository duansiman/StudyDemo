package com.epdc.gesture;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 识别手势
 */
public class RecogniseGestureActivity extends AppCompatActivity {

    private GestureOverlayView overlayView;
    private GestureLibrary gestureLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_library);

        overlayView = (GestureOverlayView) findViewById(R.id.overlayView);
        gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
        if (gestureLibrary.load()) {
            Toast.makeText(this, "手势装载成功", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "手势装载失败", Toast.LENGTH_LONG).show();
        }

        overlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                //识别手势
                ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);

                for (Prediction p:
                     predictions) {
                    if (p.score > 2.0) {
                        Toast.makeText(RecogniseGestureActivity.this, "与手势"+p.name + "的相识度"+p.score, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(RecogniseGestureActivity.this, "无匹配的手势", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
