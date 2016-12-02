package com.demo.classLib;

import java.math.BigDecimal;

public class BigDecimalDemo {

	
	public static void main(String[] args) {
		/**
		 * 使用BigDecimal(double val) 有一定不可预知性，实际上是一个近似0.1的数
		 */
		BigDecimal bd = new BigDecimal(0.1);
		System.out.println(bd.toString());
		
		BigDecimal bd2 = new BigDecimal("0.1");
		System.out.println(bd2.toString());
		
		System.out.println(BigDecimal.valueOf(0.3).toString());
	}
	
}
