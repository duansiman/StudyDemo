package com.epdc.apptest;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 测试 浏览器
 * Created by epdc on 2015/12/12.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestBrowser extends UiAutomatorTestCase {

    /**
     * 方法名 以test开头
     */
    @Test
    public void testDemo(){
        //回到主页面
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        uiDevice.pressHome();

        //获取浏览器 图标对象
        UiObject browserObject = new UiObject(new UiSelector().text("浏览器"));

        try {
            browserObject.clickAndWaitForNewWindow();

            UiObject editObject = new UiObject(new UiSelector().className("android.widget.EditText"));
            //单击
            editObject.click();

            //按删除键
            UiDevice.getInstance().pressDelete();

            //输入测试值
            editObject.setText("http://www.baidu.com");
            //按回车键
            uiDevice.pressEnter();

            //延迟2s等待网页
            sleep(2000);

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

}
