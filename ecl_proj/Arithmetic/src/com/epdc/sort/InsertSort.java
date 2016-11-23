package com.epdc.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * @author epdc
 */
public class InsertSort {

	public static void main(String[] args) {
		
		int[] datas = new int[]{5, 4, 8, 2, 1, 9, 0};
		
		for (int i = 1; i < datas.length; i++) {
			int temp = datas[i];
			int k = -1;
			for (int j = i-1; j >= 0; j--) {
				if (temp < datas[j]) {
					k = j;
					datas[j+1] = datas[j];
				}
			}
			if (k != -1) {
				datas[k] = temp;
			}
		}
		
		System.out.println(Arrays.toString(datas));
		
	}
	
}
