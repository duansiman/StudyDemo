package com.epdc.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {
	
	int countDown = 5;
	volatile double d; // 不进行任何编译器优化
	int priority;
	
	
	
	public SimplePriorities(int priority) {
		super();
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Thread.currentThread() + ":" + countDown;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(priority);
		
		while (true) {
			for (int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E) / i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}
			
			System.out.println(this);
			
			if (--countDown == 0) {
				return;
			}
		}
	}
	
	
	 public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		
		executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		
		executorService.shutdown();
	 }
}
