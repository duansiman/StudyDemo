package com.epdc.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epdc.task.LiftOff;
import com.epdc.task.PracticeOne;

public class CachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 *  Executor 管理Thread对象，它执行任务。，无需管理线程的生命周期
		 *  
		 *  ExecutorService 具有服务生命周期的Executor
		 */
		
		//newCachedThreadPool 为每个任务创建一个线程
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		//防止的新任务提交给Executor
		exec.shutdown();
		
		System.out.println("end ....");
		
//		exec.execute(new PracticeOne());
		
	}

}
