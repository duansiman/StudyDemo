package com.epdc.concurrent;

public class Joining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sleeper sleepy = new Sleeper("sleepy", 1500);
		Sleeper grump = new Sleeper("Grump", 1500);

		Joiner dopey = new Joiner("Dopey", sleepy);
		Joiner doc = new Joiner("Doc", grump);

		doc.interrupt();

	}

}

class Sleeper extends Thread {

	int duration;

	public Sleeper(String name, int sleepTime) {
		// TODO Auto-generated constructor stub

		super(name);
		duration = sleepTime;
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		try {
			sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			/**
			 * 调用interrupt时，给线程设定一个标记，表明该线程已被中断，异常被捕获时将清理这个标志
			 */
			System.out.println(getName() + " was interrupted. " + isInterrupted());
			return;
		}

		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread {
	
	Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper) {
		// TODO Auto-generated constructor stub
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			// 某个线程 调用另一个线程的join方法，次线程被挂起，直到另一个线程结束才恢复
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("interrupted");
		}
		
		System.out.println(getName() + " join completed");
	}
}
