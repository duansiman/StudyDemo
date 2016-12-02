package com.epdc.resource;

public class SynchronizedEvenGenerator extends IntGenerator {

	int currentEvenValue = 0;
	
	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new SynchronizedEvenGenerator());
	}

}
