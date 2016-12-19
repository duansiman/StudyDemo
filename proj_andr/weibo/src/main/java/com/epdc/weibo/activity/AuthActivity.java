package com.epdc.weibo.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.epdc.weibo.R;
import com.epdc.weibo.utils.DialogUtil;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        DialogUtil.show(this, R.drawable.info, R.string.title_auth_tip, R.string.text_auth_msg, "开始", "取消",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case -2://取消
                            break;
                        case -1://确定
                            break;
                    }
                }
            }
        );
    }

}
