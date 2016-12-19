package com.epdc.screenadapter;

import android.app.Activity;

/**
 *  屏幕适配
 *      1、屏幕尺寸，例如：5.5英寸，这个是指手机斜线长度
 *      2、屏幕密码：每英寸拥有的像素点。例如红米note2手机：1920 x 1080分辨率：横向有1920个像素点，纵向有1080个像素点。5.5英寸
 *          计算屏幕密码：1920^2 + 1080^2 的和开根号，然后除以英寸大小5.5。约等于400ppi
 *          如果高分辨率的图片，放低密码的屏幕上，颜色会失真。
 *      3、独立于屏幕密码的像素（dp和sp）sp用于描述字体大小，它根据用户字体选项缩放大小。
 *          密度为160时，1dp = 1sp = 1px;
 *          密码为320时，1dp = 320/160px;
 *  规则：
 *      1、限制尺寸，AndroidManifest.xml文件中通过<compatible-screens>或<supports-screens>标签
 *              注：手机去应用商店下载应用时，谷歌会检查这两个便签。如果该手机尺寸不符合，则看不到该应用。
 *      2、为不同尺寸提供不同布局，屏幕尺寸分为4个等级：small、normal、large和xlarge。
 *      建立4个布局资源目录：res/layout-small、res/layout-normal、res/layout-large和res/layout-xlarge。
 *              注：这是个模糊概念，并没有明确那个尺寸就是那个等级。
 *      3、为不同屏幕密码提供不同分辨率的图片，例如：建立res/drawable-mdpi和res/drawable-hdpi
 *
 * 每一种屏幕尺寸要求的最小屏幕长宽尺寸：
 *      1.xlarge：960dp x 720dp
        2.large：640dp x 480dp
        3.normal：470dp x 320dp
        4.small：426dp x 320dp

   屏幕最小宽度:
        res/layout-sw600dp/main_activity.xml，该布局适用屏幕最小宽度为600dp

   多语言：语言+地区
         res/values
         res/values-zh-rCN
         res/values-en
 *
 * Created by Epdc on 2015/9/16.
 */
public class ScreenAdapterActivity extends Activity {
}
