package com.epdc.java.jmx.mxbean;

/**
 * Created by devin on 2017/8/16.
 */
public interface QueueSamplerMXBean {
	public QueueSample getQueueSample();
	public void clearQueue();
}
