package com.epdc.task;

public class TestPracticeOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			new Thread(new PracticeOne()).start();
		}
	}

}
