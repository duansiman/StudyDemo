package com.epdc.java.concurrent.reorder;

/**
 * Created by devin on 2017/9/14.
 */
public class PossibleReordering {

	private static int x=0, y=0;
	private static int a=0, b=0;

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(){
			@Override
			public void run() {
				a = 1;
				x = b;
			}
		};

		Thread two = new Thread(){
			@Override
			public void run() {
				b = 1;
				y = a;
			}
		};

		one.start(); two.start();
		one.join(); two.join();
		System.out.println(String.format("x=%s,y=%s", x, y));
	}

}
