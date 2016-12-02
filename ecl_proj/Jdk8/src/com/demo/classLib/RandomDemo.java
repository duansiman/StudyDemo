package com.demo.classLib;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDemo {

	/**
	 * 	java 7 新增ThreadLocalRandom类，在并发访问下，减少多线程资源竞争，保证系统具有更好的线程安全性
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println(ThreadLocalRandom.current().nextDouble());;
	}
}
