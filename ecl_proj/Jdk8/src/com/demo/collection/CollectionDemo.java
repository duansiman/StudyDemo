package com.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class CollectionDemo {

	public static void main(String[] args) {
		/**
		 * 	�����������ӿ�������Collection��Map
		 * 
		 * 	Set ���򼯺ϣ�Ԫ�ز����ظ�
		 * 	List ���򼯺�
		 * 
		 * 	asList���صļ��ϣ�û��add��remove������
		 */
		
		List<String> list = Arrays.asList(new String[]{"hell", "world"});
		
		//Lambda���ʽ����������
		list.forEach((e)->System.out.println(e));
		
		/**
		 * 	Iterator����Collection���ϣ��������Ԫ�ز��ܸı䣬foreachҲ��һ����Iteratorʹ�õĿ���ʧ�ܻ���
		 * 	����ͨ��iterator.remove����ɾ������һ��next�������ص�Ԫ��
		 */
		
		/**
		 *  java 8 ����Predicate���ϣ�����ɾ������������Ԫ��
		 */
		List<String> list2 = new ArrayList<>();
		list2.add("hell");
		list2.add("world");
		list2.removeIf(ele-> "hell".equals(ele));
		list2.forEach((e)->System.out.println(e));
		
		/**
		 *  java 8 ����Stream�������ϣ�������֧�ִ��кͲ��оۼ�������Ԫ��
		 */
		
		IntStream is = IntStream.builder()
				.add(39)
				.add(334)
				.add(-23)
				.add(2)
				.build();
		
		//�ۼ�������ÿһ��ֻ�ܵ���һ��,����stream has already been operated upon or closed
		System.out.println(is.max().getAsInt());
		System.out.println(is.min().getAsInt());
	}
	
}
