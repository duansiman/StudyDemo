package com.epdc.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	/**
	 * 后台线程，并不属于程序中不可缺的部分，当非后台线程结束，程序也就终止了，同时会杀死所有的后台线程
	 */
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Thread deamon = new Thread(new SimpleDaemons());
			//设置为后台线程， ThreadFactor 可以设置线程的属性（后台，优先级，名称）
			deamon.setDaemon(true);
			deamon.start();
		}
		
		System.out.println(" all daemons started");
		TimeUnit.MILLISECONDS.sleep(200);
	}

}
