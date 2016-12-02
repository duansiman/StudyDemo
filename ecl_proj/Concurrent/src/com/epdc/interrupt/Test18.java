package com.epdc.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test18 {

	
	public void sleep(){
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("interupted");
		}
		System.out.println("sleep end");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new Task(new Test18()));
		exec.shutdownNow();
	}

}

class Task implements Runnable {
	
	Test18 t;
	
	public Task(Test18 t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.sleep();
		System.out.println("run end");
	}
}
