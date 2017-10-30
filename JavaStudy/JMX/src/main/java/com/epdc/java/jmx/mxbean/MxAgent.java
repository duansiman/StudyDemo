package com.epdc.java.jmx.mxbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by devin on 2017/8/16.
 */
public class MxAgent {

	public static void main(String[] args) throws Exception {
		MBeanServer mbs =
				ManagementFactory.getPlatformMBeanServer();
		ObjectName mxbeanName = new ObjectName("com.epdc.java.jmx.mxbean:type=QueueSampler");

		Queue<String> queue = new ArrayBlockingQueue<String>(10);
		queue.add("Request-1");
		queue.add("Request-2");
		queue.add("Request-3");
		QueueSampler mxbean = new QueueSampler(queue);

		mbs.registerMBean(mxbean, mxbeanName);

		System.out.println("Waiting...");
		Thread.sleep(Long.MAX_VALUE);
	}

}
