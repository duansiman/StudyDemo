package com.epdc.java.concurrent.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by devin on 2017/8/17.
 */
public class SynchronousQueueTest {

	public static void main(String[] args){
		SynchronousQueue<String> queue = new SynchronousQueue<>();

		new Thread(() -> {
			while (true) {
				try {
					System.out.println(queue.take());//需要在不同线程中才能获取队列元素
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		for (int i = 0; i < 10; i++) {
			try {
				queue.put("value " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
