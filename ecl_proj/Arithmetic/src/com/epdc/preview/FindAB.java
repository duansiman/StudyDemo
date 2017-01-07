package com.epdc.preview;
/*
	����A��1000W�����������(int)��ɣ�����㷨����������n����A���ҳ�a��bʹ��������µ�ʽ��
	
	n=a+b 
	
	˵���㷨˼·�Լ�ʱ�临�Ӷ��Ƕ���?
*/
public class FindAB {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		find(new int[]{1, 9, 10, 2, 3, 3, 4, 5, 6, 7}, 5);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	/*
	 * ����һ������Ϊn��������A��A������Ԫ�ؾ�Ϊ0.��ͷ����һ�����飬��������Ԫ��x���ڵ���nʱcontinue��С��nʱ��A(x)=1��
	 * ͬʱ���A(n-x)�Ƿ�Ϊ1�����Ϊ1��ô�����������ab�ҵ����㷨��ʱ�临�Ӷ�Ӧ��С��On
	 */
	public static boolean find(int[] A, int n) {
		byte[] temp = new byte[n-1];
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= n) {
				continue;
			}
			temp[A[i]-1] = 1;
			if(temp[(n-1)-(A[i]-1)-1] == 1) {
				System.out.println("a " + A[i] + ", b " + ((n-1)-(A[i]-1)));
				return true;
			}
		}
		return false;
	}
}
