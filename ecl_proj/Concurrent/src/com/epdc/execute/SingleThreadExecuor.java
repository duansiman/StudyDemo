package com.epdc.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epdc.task.LiftOff;

public class SingleThreadExecuor {

	public static void main(String[] args) {
		
		/**
		 * newSingleThreadExecutor 线程数量为1的 FixedThreadPool
		 * 
		 * 提交多个任务，每个任务会在下一个任务开始之前结束，这些任务排队执行。会序列化任务
		 */
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) { 
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
		
	}
	
}
