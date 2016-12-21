package com.example.livewallpaper;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

/**
 * Created by epdc on 2016/5/22.
 */
public class LiveWallpaper extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new MyEngine();
    }

    class MyEngine extends Engine {

        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            //界面是否可见
            if (visible) {
                SurfaceHolder holder = getSurfaceHolder();

                Canvas canvas = holder.lockCanvas();

//                canvas.drawText("hello world", 100, 100, new Paint());
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.test),0,0,new Paint());

                holder.unlockCanvasAndPost(canvas);
            }
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            SurfaceHolder holder = getSurfaceHolder();

            Canvas canvas = holder.lockCanvas();

            //canvas.drawText("hello world", 100, 100, new Paint());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.test),0,0,new Paint());

            holder.unlockCanvasAndPost(canvas);
        }
    }
}
