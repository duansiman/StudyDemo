package com.devin.java.uncover;


import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by devin on 2017/1/23.
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String datePattern;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat(getDatePattern());
        try {
            Date date = format.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
