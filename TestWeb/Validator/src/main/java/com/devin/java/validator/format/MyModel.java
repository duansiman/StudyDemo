package com.devin.java.validator.format;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by devin on 2017/1/12.
 */
public class MyModel {

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
