package com.epdc.java.concurrent.thread.shutdown.normal;

import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by devin on 2017/8/17.
 */
public class LoggerWriter {

	private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
	private LoggerThread thread;

	public LoggerWriter(PrintWriter writer) {
		this.thread = new LoggerThread(writer);
	}

	public void start(){
		this.thread.start();
	}

	public void log(String msg) throws InterruptedException {
		queue.put(msg);
	}

	private class LoggerThread extends Thread {

		private PrintWriter writer;

		public LoggerThread(PrintWriter writer){
			this.writer = writer;
		}

		@Override
		public void run() {
			try {
				while (true) {
					String msg = queue.take();
					writer.println(msg);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}
		}
	}

}
