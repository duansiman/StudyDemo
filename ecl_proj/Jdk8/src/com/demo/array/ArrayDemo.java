package com.demo.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ArrayDemo {

	public static void main(String[] args) {
		/**
		 * jdk 8 利用CPU并行能力，提供设值，排序的性能, parallel开头的方法
		 */
		
		int[] arrs = new int[]{4, 2, 7, 4, 0};
		
		//重新计算数组元素值，right当前元素，left为前一个元素。计算第一个时，left为1
		Arrays.parallelPrefix(arrs, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				return left+right;
			}
		});
		
		Arrays.parallelSort(arrs);
		System.out.println(Arrays.toString(arrs));
		
		/**
		 *  improt 和 import static 后一个引入静态成员变量，方法
		 */
	}
	
}
