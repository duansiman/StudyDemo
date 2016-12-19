package com.epdc.commonusewidget;

/**
 * Created by Epdc on 2015/8/22.
 */
public class CustomListViewDate {
    private int iconId;
    private String title;
    private String dec;

    public CustomListViewDate(int iconId, String title, String dec) {
        this.iconId = iconId;
        this.title = title;
        this.dec = dec;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
