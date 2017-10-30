package com.epdc.java.concurrent.executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by devin on 2017/8/17.
 * 饱和策略
 */
public class PolicyTest {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(2));
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//调用者运行策略
		//当等待队列满了，会在调用execute方法所在线程中执行任务, 下面例子即main线程

		for (int i = 0; i < 4; i++) {
			executor.execute(() -> {
				try {
					Thread.sleep(1000);
					System.out.println("done");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		executor.execute(() -> {
			System.out.println(Thread.currentThread().getName() + " 最后提交的");
		});

	}

}
