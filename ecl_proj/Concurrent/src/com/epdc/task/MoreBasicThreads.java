package com.epdc.task;

public class MoreBasicThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			//�������ŵ��߳��ϣ� startΪ���߳�ִ�г�ʼ������
			new Thread(new LiftOff()).start();
		}
		System.out.println("waiting liftoff");
	}

}
