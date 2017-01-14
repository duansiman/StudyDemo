package com.epdc.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epdc.task.LiftOff;

public class SingleThreadExecuor {

	public static void main(String[] args) {
		
		/**
		 * newSingleThreadExecutor �߳�����Ϊ1�� FixedThreadPool
		 * 
		 * �ύ�������ÿ�����������һ������ʼ֮ǰ��������Щ�����Ŷ�ִ�С������л�����
		 */
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) { 
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
		
	}
	
}
