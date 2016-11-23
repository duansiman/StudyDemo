package com.epdc.callable;

import java.util.concurrent.TimeUnit;

public class Daemons {

	/**
	 * 后台线程创建的线程也是后台线程，即使没有显式设置为后台线程
	 * @param args
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d is daemon " + d.isDaemon());
		TimeUnit.SECONDS.sleep(1);
	}
	
}

class Daemon implements Runnable {

	Thread[] t = new Thread[10];
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < t.length; i++) {
			t[i]= new Thread(new DaemonSpawn());
			t[i].start();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("t["+i+"] is daemon "+ t[i].isDaemon());
		}
		
		while (true) {
			Thread.yield();
		}
	}
	
}

class DaemonSpawn implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Thread.yield();
		}
	}
	
}
