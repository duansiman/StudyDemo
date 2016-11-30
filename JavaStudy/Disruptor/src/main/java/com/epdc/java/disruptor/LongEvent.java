package com.epdc.java.disruptor;

/**
 * Created by devin on 2016/11/30.
 */
public class LongEvent
{
    private long value;

    public void set(long value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
