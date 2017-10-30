package com.epdc.java.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by devin on 2017/8/16.
 */
public class HelloJMXAgent {

	public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

		ObjectName name = new ObjectName("com.epdc.java.jmx:type=Hello");
		Hello mbean = new Hello();
		mBeanServer.registerMBean(mbean, name);

		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
	}

}
