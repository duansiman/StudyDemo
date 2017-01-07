package com.epdc.preview;
/*
	数组A由1000W个随机正整数(int)组成，设计算法，给定整数n，在A中找出a和b使其符合如下等式：
	
	n=a+b 
	
	说明算法思路以及时间复杂度是多少?
*/
public class FindAB {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		find(new int[]{1, 9, 10, 2, 3, 3, 4, 5, 6, 7}, 5);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	/*
	 * 创建一个长度为n的新数组A，A中所有元素均为0.从头遍历一遍数组，当遍历的元素x大于等于n时continue，小于n时令A(x)=1，
	 * 同时检查A(n-x)是否为1，如果为1那么所求的两个数ab找到。算法的时间复杂度应该小于On
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
