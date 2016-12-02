package com.demo.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ArrayDemo {

	public static void main(String[] args) {
		/**
		 * jdk 8 ����CPU�����������ṩ��ֵ�����������, parallel��ͷ�ķ���
		 */
		
		int[] arrs = new int[]{4, 2, 7, 4, 0};
		
		//���¼�������Ԫ��ֵ��right��ǰԪ�أ�leftΪǰһ��Ԫ�ء������һ��ʱ��leftΪ1
		Arrays.parallelPrefix(arrs, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				return left+right;
			}
		});
		
		Arrays.parallelSort(arrs);
		System.out.println(Arrays.toString(arrs));
		
		/**
		 *  improt �� import static ��һ�����뾲̬��Ա����������
		 */
	}
	
}
