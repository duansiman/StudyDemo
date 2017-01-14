package com.epdc.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NativeExceptionHanding implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

	public static void main(String[] args) { 
		// TODO Auto-generated method stub

		/**
		 *  不能捕获从线程中逃逸的异常，一旦逃出就会向控制台传播
		 */
		
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new NativeExceptionHanding());
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			System.out.println("exception has been handle");
		}
		
	}

}
