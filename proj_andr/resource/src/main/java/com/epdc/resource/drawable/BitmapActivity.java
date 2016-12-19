package com.epdc.resource.drawable;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.epdc.resource.R;

import java.io.IOException;
import java.io.InputStream;

/**
 *  广义角度： android中图片不仅包括 .png、.jpg 、.gif格式位图，还包括xml资源定义的drawable对象。
 *
 *  Bitmap 代表一个位图，BitmapDrawable是封装bitmap的对象。
 *  Bitmap提供一些静态方法创建Bitmap，还有BitmapFactory工具类，提供大量方法解析、创建Bitmap对象。
 *  系统不断解析、创建Bitmap对象，会造成内存泄漏，于是Bitmap提供两个方法判断它是否已回收
 *  isRecycled()
 *  recycled()
 */

public class BitmapActivity extends AppCompatActivity {


    int index;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        image = (ImageView) findViewById(R.id.image);

        final AssetManager assets = getAssets();
        try {
            //获取所以文件，assets目录下
            final String[] list = assets.list("");

            findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    while (true) {
                        if (index >= list.length) {
                            index = 0;
                        }

                        InputStream open = null;
                        if (list[index].endsWith(".png") || list[index].endsWith(".jpg") || list[index].endsWith(".gif")) {
                            try {
                                open = assets.open(list[index]);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                            //回收
                            if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
                                bitmapDrawable.getBitmap().recycle();
                            }

                            image.setImageBitmap(BitmapFactory.decodeStream(open));

                            index++;
                            break;
                        }

                        index++;
                    }

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
