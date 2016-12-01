package com.epdc.java.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by devin on 2016/11/30.
 */
public class LongEventFactory implements EventFactory<LongEvent>
{

    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}
