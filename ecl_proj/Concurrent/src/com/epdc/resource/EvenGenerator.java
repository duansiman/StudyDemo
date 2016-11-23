package com.epdc.resource;

public class EvenGenerator extends IntGenerator {

	int currentEvenValue = 0;
	
	@Override
	public int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield(); // ≤ªª· Õ∑≈À¯
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new EvenGenerator());
	}

}
