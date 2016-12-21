package com.epdc.apptest;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.view.KeyEvent;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/13.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestAPI {

    /**
     * 按键 API
     */
    public void testKeyCode(){
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        //输入字母
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_A);
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_B);
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_D);

        //输入大写字母
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_A, 1);
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_B, 1);
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_D, 1);
    }

    /**
     * 点击和坐标 API
     */
    public void testClick(){
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

//        uiDevice.click(250, 650);

        //获取屏幕的高宽度
        int displayWidth = uiDevice.getDisplayWidth();
        int displayHeight = uiDevice.getDisplayHeight();

        UiObject picture = new UiObject(new UiSelector().text("图库"));

        try {
            Rect rect = picture.getBounds();
            uiDevice.click(rect.centerX(), rect.centerY());
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 拖动和滑动 API
     */
    public void testDragAndSwipe() throws UiObjectNotFoundException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        UiObject picture = new UiObject(new UiSelector().text("图库"));
        Rect rect = picture.getBounds();

        //拖动   是把一个对象从一个坐标点拖到另一个坐标点
        //最后一个参数是 步长时间
//        uiDevice.drag(rect.centerX(), rect.centerY(), rect.centerX(), rect.centerY() - 200, 30);

        //滑动  从一个坐标点滑到另一个坐标点
        //获取屏幕的高宽度
        int displayWidth = uiDevice.getDisplayWidth();
        int displayHeight = uiDevice.getDisplayHeight();

//        uiDevice.swipe(displayWidth-50, displayHeight/2, 100, displayHeight/2, 30);

        //可以实现手势操作
        Point[] points = new Point[] {new Point(100, 100), new Point(200, 100), new Point(200, 200), new Point(100, 200)};
        uiDevice.swipe(points, 30);

    }

    /**
     * 旋转 API
     * @throws RemoteException
     */
    public void testOrientation() throws RemoteException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        uiDevice.setOrientationLeft();
    }

    /**
     * 屏幕 唤醒和点亮
     */
    public void testWakeupAndSleep() throws RemoteException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (uiDevice.isScreenOn()) {
            uiDevice.sleep();
        }
    }

    /**
     * 截图 API
     */
    public void testScreen(){
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        uiDevice.takeScreenshot(new File("/sdcard/test.png"));
    }
    /**
     * 等待空闲时间
     */
    public void testIdle(){
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        uiDevice.click(250, 650);

        //默认10s,超过10s报错
        uiDevice.waitForIdle();
    }

    /**
     * 包名、通知栏、快速设置、布局文件 api
     */
    public void testPackage() throws IOException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        String currentPackageName = uiDevice.getCurrentPackageName();
        System.out.println(currentPackageName);

        //打开通知栏
//        uiDevice.openNotification();

        //打开快速设置
//        uiDevice.openQuickSettings();
        //得到界面 布局文件
        uiDevice.dumpWindowHierarchy("n.xml");
    }

    /**
     * UiOjbect api
     */
    public void testUiOjbect() throws UiObjectNotFoundException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiObject uiObject = uiDevice.findObject(new UiSelector().text("图库"));

        //超时时间5500ms
//        uiObject.clickAndWaitForNewWindow();
        //长按事件，可以swipe实现
//        uiObject.longClick();

        //输入文本和清除
        uiObject = uiDevice.findObject(new UiSelector().resourceId("com.android.mms:id/recipients_editor"));

//        uiObject.setText("kkkkkkkkk");
//        uiObject.clearTextField();

        uiObject = uiDevice.findObject(new UiSelector().text("接收者"));

        //将光标移到末尾
        uiDevice.pressKeyCode(KeyEvent.KEYCODE_MOVE_END);
        while (!uiObject.exists()) {
            uiDevice.pressKeyCode(KeyEvent.KEYCODE_DEL);
        }
    }

    @Test
    public void test() throws Exception {
        testUiOjbect();
    }

}
