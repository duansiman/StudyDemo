package com.demo.classLib;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDemo {

	/**
	 * 	java 7 ����ThreadLocalRandom�࣬�ڲ��������£����ٶ��߳���Դ��������֤ϵͳ���и��õ��̰߳�ȫ��
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println(ThreadLocalRandom.current().nextDouble());;
	}
}
