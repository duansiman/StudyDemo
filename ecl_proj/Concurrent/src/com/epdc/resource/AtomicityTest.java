package com.epdc.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {

	private int i = 0;
	public int getValue(){return i;}
	private synchronized void evenIncrement(){i++;i++;}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			evenIncrement();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		executorService.execute(at);
		
		while(true) {
			int val = at.getValue();
			if (val % 2 != 0 ) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}
