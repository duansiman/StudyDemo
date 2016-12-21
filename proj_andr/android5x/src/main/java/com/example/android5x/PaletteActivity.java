package com.example.android5x;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.Window;

import com.epdc.commonlib.utils.LogUtil;


/**
 *  Palette 从Bitmap提取颜色
 */

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        Palette.Builder builder = Palette.from(bitmap);
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {

                LogUtil.d(palette.getMutedSwatch()+"");
                LogUtil.d(palette.getLightVibrantSwatch()+"");//不为空
                LogUtil.d(palette.getDarkVibrantSwatch()+"");
                LogUtil.d(palette.getDarkMutedSwatch()+"");
                LogUtil.d(palette.getVibrantSwatch()+"");//不为空
                LogUtil.d(palette.getLightMutedSwatch()+"");


                Window window = getWindow();
                window.setStatusBarColor(palette.getVibrantSwatch().getRgb());

                for (Palette.Swatch sw : palette.getSwatches()) {
                    if (sw != null) {
                        LogUtil.d(sw.toString());
                    }
                }
            }
        });

    }
}
