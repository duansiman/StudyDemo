package com.epdc.commonlib.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by epdc on 2016/7/5.
 */
public class PicassoUtil {

    public static void loadImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url).into(imageView);
    }

}
