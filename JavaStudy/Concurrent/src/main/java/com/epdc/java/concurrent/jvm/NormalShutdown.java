package com.epdc.java.concurrent.jvm;

/**
 * Created by devin on 2017/8/17.
 */
public class NormalShutdown {

	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("hook");
		}));

		new Thread(() -> {
			try {
				System.out.println("thread start");
				Thread.sleep(1000);
				System.out.println("thread end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		System.out.println("done");
		System.exit(0);//不会停止或中断任何正在执行线程

	}

}
