package com.epdc.java.jmx;

/**
 * Created by devin on 2017/8/16.
 */
public interface HelloMBean {

	public void sayHello();
	public int add(int x, int y);

	public String getName();

	public int getCacheSize();
	public void setCacheSize(int size);

}
