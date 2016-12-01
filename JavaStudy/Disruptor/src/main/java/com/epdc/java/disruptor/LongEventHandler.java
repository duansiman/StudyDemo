package com.epdc.java.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by devin on 2016/11/30.
 */
public class LongEventHandler implements EventHandler<LongEvent>
{
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event);
    }
}
