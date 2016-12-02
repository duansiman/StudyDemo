package com.epdc.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialNumberChecker {

	static final int SIZE = 10;
	static CircularSet serials = new CircularSet(1000);
	static ExecutorService exec = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new SerialChecker());
		}
		
	}
	
	static class SerialChecker implements Runnable {
		@Override
		public void run() {
			while (true) {
				// TODO Auto-generated method stub
				int serial = SerialNumberGenerator.nextSerialNumber();
				if (serials.contains(serial)) {
					System.out.println("Duplicate " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}

}

class CircularSet {
	int[] array;
	int len;
	int index = 0;
	
	public CircularSet(int size) {
		// TODO Auto-generated constructor stub
		array = new int[size];
		len = size;
		for (int i = 0; i < size; i++) {
			array[i] = -1;
		}
	}
	
	public synchronized void add(int i) {
		array[index] = i;
		index = ++index % len;
	}
	
	public synchronized boolean contains(int val) {
		for (int i = 0; i < len; i++) {
			if (array[i] == val) {
				return true;
			}
		}
		
		return false;
	}
}
