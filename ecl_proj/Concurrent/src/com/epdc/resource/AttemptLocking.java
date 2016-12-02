package com.epdc.resource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

	ReentrantLock lock = new ReentrantLock();
	
	public void untimed() {
		// TODO Auto-generated method stub
		boolean captured = lock.tryLock();//≥¢ ‘ªÒ»°À¯
		try {
			System.out.println("tryLock() " + captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}
	
	public void timed() {
		boolean captured = false;
		
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		try {
			System.out.println("tryLock 2 seconds " + captured);
		} finally {
			// TODO: handle finally clause
			if (captured) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AttemptLocking al = new AttemptLocking();
		al.untimed();
		al.timed();
		
		new Thread(){
			{setDaemon(true);}
			public void run() {
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		
		TimeUnit.SECONDS.sleep(1);
//		Thread.yield();
		
		al.untimed();
		al.timed();
	}
	
}
