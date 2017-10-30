package com.epdc.java.concurrent.thread.shutdown.abnormal;

/**
 * Created by devin on 2017/8/17.
 */
public class UncaughtException {

	public static void main(String[] args) {

		Thread t = new Thread(() -> {
			System.out.println(1/0);
		});

		t.setUncaughtExceptionHandler((t1, e) -> {//捕捉未catch的异常
			System.out.println(e.getMessage());
		});

		t.start();
	}

}
