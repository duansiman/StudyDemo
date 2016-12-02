package com.epdc.task;

public class PracticeOne implements Runnable {

	static int taskCount = 0;
	final int id = taskCount++;

	public PracticeOne() {
		// TODO Auto-generated constructor stub
		System.out.println("#" + id + " task start");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("#" + id + " task 0");
		Thread.yield();
		
		System.out.println("#" + id + " task 1");
		Thread.yield();
		
		System.out.println("#" + id + " task 2");
		Thread.yield();
		
		System.out.println("#" + id + " task end");
	}

	
	
}
