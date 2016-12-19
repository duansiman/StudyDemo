package com.epdc.gesture;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class GestureLibraryActivity extends AppCompatActivity {

    private GestureOverlayView overlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_library);

        overlayView = (GestureOverlayView) findViewById(R.id.overlayView);

        //设置颜色
        overlayView.setGestureColor(Color.RED);

        //设置绘制宽度
        overlayView.setGestureStrokeWidth(4);

        //绘制完成监听
        overlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.save, null);

                ImageView imageView = (ImageView) saveDialog.findViewById(R.id.show);
                final EditText gestureName = (EditText) saveDialog.findViewById(R.id.gesture_name);

                //根据手势创建位图
                Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                imageView.setImageBitmap(bitmap);

                new AlertDialog.Builder(GestureLibraryActivity.this)
                        .setView(saveDialog)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GestureLibrary gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
                                gestureLibrary.addGesture(gestureName.getText().toString(), gesture);
                                gestureLibrary.save();
                            }
                        }).setNegativeButton("取消", null).show();
            }
        });
    }
}
