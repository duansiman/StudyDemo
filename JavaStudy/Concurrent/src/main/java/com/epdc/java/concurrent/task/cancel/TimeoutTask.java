package com.epdc.java.concurrent.task.cancel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by devin on 2017/8/16.
 */
public class TimeoutTask {

	private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(10);

	public static void main(String[] args) {
		timedRun(() -> {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				System.out.println("interrupt");
				e.printStackTrace();
			}
		}, 100L, TimeUnit.MILLISECONDS);
	}

	public static void timedRun(Runnable r, long timeout, TimeUnit unit){
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(taskThread::interrupt, timeout, unit);//timeout 后中断线程
		r.run();
	}

}
