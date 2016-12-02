package com.demo.collection;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import com.demo.enum2.ColorEnum;

public class SetDemo {

	public static void main(String[] args) {
		/**
		 *  HashSet ��Hash�㷨���洢�����е�Ԫ��,����hashCode���������Ĵ洢λ��
		 *  	1������֤Ԫ������˳��
		 *  	2������ͬ��
		 *  	3��������nullԪ��
		 * 
		 * 	�жϵ�����Ԫ���Ƿ���ȣ�
		 * 		ͨ��equals��hashCode�ķ���ֵ��������Ϊtrueʱ���
		 * 
		 * 	LinkedHashSet
		 * 		ʹ������ά��Ԫ�صĴ���
		 * 
		 * 	TreeSet
		 * 		����Ԫ�ش�������״̬����Ҫ�������ά������Ԫ�صĴ���
		 * 		����Ԫ�ص�compareTo�������Ƚϴ�С�����������򣬼���Ȼ����Ԫ����Ҫʵ��Comparable�ӿ�
		 * 		������ͬһ�����͵Ķ���
		 * 
		 * 	EnumSet
		 * 		�洢��ʽ�ǳ����գ���Ч
		 * 		Ϊö������Ƽ����࣬Ҳ������ģ�Enum�ඨ���˳��
		 * 
		 * 	�������̰߳�ȫ�ģ�����ͨ��Collections.synchronizedSortedSet��װset����
		 * 
		 */
		
		Set<String> set = new HashSet<>();
		set.add("hello");
		
		EnumSet<ColorEnum> enumSet = EnumSet.allOf(ColorEnum.class);
		System.out.println(enumSet);
	}
	
}
