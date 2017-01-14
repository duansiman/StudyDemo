package com.epdc.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置默认的异常处理器
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	} 

}
