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
		 *  ���ܲ�����߳������ݵ��쳣��һ���ӳ��ͻ������̨����
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
