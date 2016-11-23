package com.epdc.resource;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EvenChecker implements Runnable {

	IntGenerator generator;
	
	final int id;
	
	public EvenChecker(IntGenerator g, int ident) {
		// TODO Auto-generated constructor stub
		this.id = ident;
		this.generator = g;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even");
				generator.cancel();
			}
		}
	}
	
	public static void test(IntGenerator gp, int count) {
		ExecutorService exec  = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			
			exec.execute(new EvenChecker(gp, i));
			
		}
		
		exec.shutdown();
	}
	
	public static void test(IntGenerator g) {
		test(g, 10);
	}

}
