package com.epdc.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epdc.task.LiftOff;
import com.epdc.task.PracticeOne;

public class CachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 *  Executor ����Thread������ִ�����񡣣���������̵߳���������
		 *  
		 *  ExecutorService ���з����������ڵ�Executor
		 */
		
		//newCachedThreadPool Ϊÿ�����񴴽�һ���߳�
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		//��ֹ���������ύ��Executor
		exec.shutdown();
		
		System.out.println("end ....");
		
//		exec.execute(new PracticeOne());
		
	}

}
