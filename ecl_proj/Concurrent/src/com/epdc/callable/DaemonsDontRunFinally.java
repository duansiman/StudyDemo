package com.epdc.callable;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
		
		/**
		 *  后台线程在不执行finally 就会终止run方法
		 */
	}

}

class ADaemon implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(" daemon started ");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(" this should always run ?");
		}
	}
	
}
