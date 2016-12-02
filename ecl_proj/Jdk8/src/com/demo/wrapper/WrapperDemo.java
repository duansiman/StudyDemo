package com.demo.wrapper;

public class WrapperDemo {

	public static void main(String[] args) {
		/**
		 *  �������͵ķ�װ�࣬ java 5��֧���Զ�װ�䣬�Զ�����
		 */
		
		/**
		 * Integer ������-128��127֮���ֵ
		 */
		Integer i1 = Integer.valueOf(5);
		Integer i2 = Integer.valueOf(5);
		
		System.out.println(new Integer(5) == new Integer(5));
		System.out.println(i1 == i2);
		
		Integer i3 = 225;
		Integer i4 = 225;
		System.out.println(i3 == i4);
		
		/**
		 *  java 7 Ϊ���а�װ���ṩcompare��̬�������Ƚϴ�С
		 */
		
		System.out.println(Integer.compare(4, 5));
		
		/**
		 * java 8 Ϊ���а�װ���ṩ�޷�������
		 */
		byte b = -3;
		System.out.println(Byte.toUnsignedInt(b));
	}
	
}
