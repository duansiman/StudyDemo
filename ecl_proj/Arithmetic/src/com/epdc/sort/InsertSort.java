package com.epdc.sort;

import java.util.Arrays;

/**
 * ֱ�Ӳ�������
 * 
 * ��һ����¼���뵽������õ�������У��Ӷ��õ�һ���£���¼����1�������
 * �����Ƚ����еĵ�1����¼������һ������������У�Ȼ��ӵ�2����¼������в��룬ֱ��������������Ϊֹ��
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
