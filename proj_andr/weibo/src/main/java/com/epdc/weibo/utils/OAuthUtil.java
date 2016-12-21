package com.epdc.weibo.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.epdc.weibo.model.Constants;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

/**
 * Created by Administrator on 2015/11/15.
 */
public class OAuthUtil {

    private static AuthInfo mAuthInfo;
    private static OAuthUtil mOAuthUtil;
    private static Activity mActivity;

    private OAuthUtil(){}

    public static OAuthUtil getInstance(Activity activity){
        if (mAuthInfo == null) {
            mOAuthUtil = new OAuthUtil();
            mActivity = activity;
            mAuthInfo = new AuthInfo(mActivity, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
        }
        return mOAuthUtil;
    }

    public SsoHandler clientOAuth(){
        SsoHandler ssoHandler = new SsoHandler(mActivity, mAuthInfo);
        ssoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                Oauth2AccessToken mAccessToken = Oauth2AccessToken.parseAccessToken(bundle); // 从 Bundle 中解析 Token
                if (mAccessToken.isSessionValid()) {
                    System.out.println("accessToken:" + mAccessToken.getToken());
                } else {
                    // 当您注册的应用程序签名不正确时，就会收到错误Code，请确保签名正确
                    String code = bundle.getString("code", "");
                    System.out.println("code:" + code);
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                System.out.println("client exception");
            }

            @Override
            public void onCancel() {
                System.out.println("client cancel");
            }
        });
        return ssoHandler;
    }

    public SsoHandler smsOAuth(){
        SsoHandler ssoHandler = new SsoHandler(mActivity, mAuthInfo);
        ssoHandler.registerOrLoginByMobile("", new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                Oauth2AccessToken mAccessToken = Oauth2AccessToken.parseAccessToken(bundle); // 从 Bundle 中解析 Token
                String phoneNum = mAccessToken.getPhoneNum();//用户输入的电话号码
                if (mAccessToken.isSessionValid()) {
                    System.out.println("accessToken:" + mAccessToken.getToken());
                    System.out.println("phoneNum:" + phoneNum);
                } else {
                    // 当您注册的应用程序签名不正确时，就会收到错误Code，请确保签名正确
                    String code = bundle.getString("code", "");
                    System.out.println("code:" + code);
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                System.out.println("sms exception");
            }

            @Override
            public void onCancel() {
                System.out.println("sms cancel");
            }
        });
        return ssoHandler;
    }

}
