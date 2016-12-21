package com.epdc.media;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * 屏幕捕捉，即截屏
 */
public class ScreenProjectionActivity extends AppCompatActivity {

    private ToggleButton togProjection;
    private SurfaceView surfaceView;
    private MediaProjectionManager projectionManager;

    final static int CAPTURE_CODE = 0x123;
    private int densityDpi;
    private Surface surface;
    private MediaProjection mediaProjection;
    private VirtualDisplay virtualDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_projection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //获取屏幕分辨率
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        densityDpi = metrics.densityDpi;

        togProjection = (ToggleButton) findViewById(R.id.togProjection);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        surface = surfaceView.getHolder().getSurface();
        ViewGroup.LayoutParams lp = surfaceView.getLayoutParams();
        lp.width = 360;
        lp.height = 640;
        surfaceView.setLayoutParams(lp);

        togProjection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    projectionScreen();
                } else {
                    stopScreen();
                }
            }
        });

        //获得屏幕捕捉管理对象
        projectionManager = (MediaProjectionManager) this.getSystemService(MEDIA_PROJECTION_SERVICE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaProjection != null) {
            mediaProjection.stop();
            mediaProjection = null;
        }
    }

    private void stopScreen() {
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
    }

    private void projectionScreen() {

        if (surface == null || projectionManager == null) {
            return;
        }

        //屏幕捕捉的intent
        Intent screenCaptureIntent = projectionManager.createScreenCaptureIntent();

        startActivityForResult(screenCaptureIntent, CAPTURE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_CODE) {
            if (resultCode != RESULT_OK) {//用户拒绝了屏幕捕捉
                System.out.println("用户拒绝了屏幕捕捉");
                return;
            }

            mediaProjection = projectionManager.getMediaProjection(resultCode, data);
            virtualDisplay = mediaProjection.createVirtualDisplay("屏幕捕捉", 360, 640, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR, densityDpi, surface, null, null);
        }
    }
}
