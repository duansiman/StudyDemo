package com.epdc.java.concurrent.thread.shutdown.abnormal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by devin on 2017/8/17.
 */
public class ThreadPool {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {//给线程池中工作线程增加UncaughtExceptionHandler
				Thread t = new Thread(r);
				t.setUncaughtExceptionHandler((t1, e) -> System.out.println(e.getMessage()));
				return t;
			}
		});

		executorService.execute(() -> System.out.println(1/0));
		executorService.execute(() -> System.out.println("normal"));

		executorService.shutdown();

	}

}
