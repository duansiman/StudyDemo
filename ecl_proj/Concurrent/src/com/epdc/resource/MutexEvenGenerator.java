package com.epdc.resource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

	int currentEvenValue = 0;
	Lock lock = new ReentrantLock();
	
	@Override
	public int next() {
		// TODO Auto-generated method stub
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new SynchronizedEvenGenerator());
	}

}
