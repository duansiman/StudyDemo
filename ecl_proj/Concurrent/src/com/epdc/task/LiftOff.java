package com.epdc.task;

/**
 * Runnable ��������
 * @author epdc
 *
 */
public class LiftOff implements Runnable {

	protected int countDown = 10;
	
	protected static int taskCount = 0;
	
	protected final int id = taskCount ++;
	
	public LiftOff(){}
	
	public LiftOff(int countDown) {
		super();
		this.countDown = countDown;
	}


	public String status(){
		return "#" + id + " (" + (countDown > 0 ? countDown : "LiftOff") + ")";
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown -- > 0) {
			System.out.println(status());
			//���̵߳�������һ�ֽ��飬CPU���Դ�һ���߳�ת�Ƶ���һ���߳�
			Thread.yield();
		}
	}


}
