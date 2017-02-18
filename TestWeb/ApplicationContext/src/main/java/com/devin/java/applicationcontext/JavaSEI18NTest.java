package com.devin.java.applicationcontext;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by devin on 2017/2/3.
 */
public class JavaSEI18NTest {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("com/devin/java/applicationcontext/messages", Locale.CHINA);
        System.out.println(bundle.getString("hello"));

        bundle = ResourceBundle.getBundle("com/devin/java/applicationcontext/messages", Locale.US);
        System.out.println(bundle.getString("hello"));
    }

}
