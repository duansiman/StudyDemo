package com.epdc.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	/**
	 * ��̨�̣߳��������ڳ����в���ȱ�Ĳ��֣����Ǻ�̨�߳̽���������Ҳ����ֹ�ˣ�ͬʱ��ɱ�����еĺ�̨�߳�
	 */
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Thread deamon = new Thread(new SimpleDaemons());
			//����Ϊ��̨�̣߳� ThreadFactor ���������̵߳����ԣ���̨�����ȼ������ƣ�
			deamon.setDaemon(true);
			deamon.start();
		}
		
		System.out.println(" all daemons started");
		TimeUnit.MILLISECONDS.sleep(200);
	}

}
