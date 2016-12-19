package com.epdc.weibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.epdc.weibo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/11/11.
 */
public class LoginActivity extends BaseActivity {

    @InjectView(R.id.image_add_account)
    ImageView imageAddAccount;

    @InjectView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        imageAddAccount.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_login:
                Intent intent = new Intent(this, AuthActivity.class);
                startActivity(intent);
                break;
        }
    }
}
