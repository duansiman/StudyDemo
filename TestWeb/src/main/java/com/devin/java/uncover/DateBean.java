package com.devin.java.uncover;

import java.util.Date;

/**
 * Created by devin on 2017/1/23.
 */
public class DateBean {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateBean{" +
                "date=" + date +
                '}';
    }
}
