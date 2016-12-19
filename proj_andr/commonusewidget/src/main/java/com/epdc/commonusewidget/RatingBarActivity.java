package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.epdc.commonusekownledge.R;

/**
 * 评价控件，五星
 * Created by Epdc on 2015/8/28.
 */
public class RatingBarActivity extends Activity{

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RatingBarActivity.this,String.format("%f",rating),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
