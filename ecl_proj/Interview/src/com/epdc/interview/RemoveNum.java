package com.epdc.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 一个整形集合，只包含0-13之间的整数，移除集合中两个数相加等于14的数，求剩余数
 * @author epdc
 *
 */
public class RemoveNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrs = new int[]{1, 13, 7, 2, 12, 9, 5, 5, 2, 12};
		
		ArrayList<Integer> lists = new ArrayList<>();
		for (int i = 0; i < arrs.length; i++) {
			lists.add(arrs[i]);
		}
		
		for (int i = 1; i <= 7; i++) {
			int start = -1;
			while ((start = lists.indexOf(i)) >= 0) {
				int end = -1;
				if ((end = lists.lastIndexOf(14-i)) >= 0) {
					System.out.println(i + " start:" + start + ", end:"+end);
					if (start < end) {
						lists.remove(start);
						lists.remove(end-1);
					} else if(start > end){
						lists.remove(start);
						lists.remove(end);
					} else {
						break;
					}
					System.out.println(lists);
				} else {
					break;
				}
			}
		}
		System.out.println(lists);
		
	}

}
