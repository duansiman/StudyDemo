package com.devin.java.uncover;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by devin on 2017/1/19.
 */
public class NextDayDateFactoryBean implements FactoryBean<Date> {
    @Override
    public Date getObject() throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+1);
        return c.getTime();
    }

    @Override
    public Class<?> getObjectType() {
        return Date.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
