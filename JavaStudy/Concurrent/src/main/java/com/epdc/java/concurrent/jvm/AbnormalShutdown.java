package com.epdc.java.concurrent.jvm;

/**
 * Created by devin on 2017/8/17.
 */
public class AbnormalShutdown {

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
		Runtime.getRuntime().halt(1);//非正常关闭，不会执行钩子线程

	}

}
