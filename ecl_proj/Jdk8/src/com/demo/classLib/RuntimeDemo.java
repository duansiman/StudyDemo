package com.demo.classLib;

public class RuntimeDemo {

	public static void main(String[] args) {
		/**
		 * 	����java���������ʱ����
		 * 
		 * 	�ṩload(filename) ���������ļ�
		 * 	�ṩloadLibrary(libname) �������ض�̬���ӿ�
		 * 
		 * 	���Է���JVM�������Ϣ����������Ϣ���ڴ���Ϣ
		 * 
		 */
		
		Runtime rt = Runtime.getRuntime();
		
		System.out.println("������������" + rt.availableProcessors());
		
		System.out.println(rt.freeMemory() + ":" + rt.maxMemory());
		
		System.out.println("�����ڴ棺" + (rt.freeMemory() / 1024 / 1024));
		
		System.out.println("��������ڴ�" + (rt.maxMemory() / 1024 / 1024));
	}
	
}
