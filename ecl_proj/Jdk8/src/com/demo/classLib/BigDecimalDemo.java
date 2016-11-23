package com.demo.classLib;

import java.math.BigDecimal;

public class BigDecimalDemo {

	
	public static void main(String[] args) {
		/**
		 * ʹ��BigDecimal(double val) ��һ������Ԥ֪�ԣ�ʵ������һ������0.1����
		 */
		BigDecimal bd = new BigDecimal(0.1);
		System.out.println(bd.toString());
		
		BigDecimal bd2 = new BigDecimal("0.1");
		System.out.println(bd2.toString());
		
		System.out.println(BigDecimal.valueOf(0.3).toString());
	}
	
}
