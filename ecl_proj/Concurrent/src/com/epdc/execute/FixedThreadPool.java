package com.epdc.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epdc.task.LiftOff;
import com.epdc.task.PracticeOne;

public class FixedThreadPool {

	public static void main(String[] args) {
		
		/**
		 *  newFixedThreadPool ʹ�������̼߳�
		 */
		
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
		
//		exec.execute(new PracticeOne());
	}
	
}
