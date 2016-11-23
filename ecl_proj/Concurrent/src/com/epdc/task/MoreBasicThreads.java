package com.epdc.task;

public class MoreBasicThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			//将任务附着到线程上， start为该线程执行初始化操作
			new Thread(new LiftOff()).start();
		}
		System.out.println("waiting liftoff");
	}

}
