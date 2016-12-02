package com.demo.wrapper;

public class WrapperDemo {

	public static void main(String[] args) {
		/**
		 *  基本类型的封装类， java 5后支持自动装箱，自动拆箱
		 */
		
		/**
		 * Integer 缓存了-128到127之间的值
		 */
		Integer i1 = Integer.valueOf(5);
		Integer i2 = Integer.valueOf(5);
		
		System.out.println(new Integer(5) == new Integer(5));
		System.out.println(i1 == i2);
		
		Integer i3 = 225;
		Integer i4 = 225;
		System.out.println(i3 == i4);
		
		/**
		 *  java 7 为所有包装类提供compare静态方法，比较大小
		 */
		
		System.out.println(Integer.compare(4, 5));
		
		/**
		 * java 8 为所有包装类提供无符号运算
		 */
		byte b = -3;
		System.out.println(Byte.toUnsignedInt(b));
	}
	
}
