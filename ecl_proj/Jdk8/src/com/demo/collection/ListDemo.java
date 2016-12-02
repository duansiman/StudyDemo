package com.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		/**
		 *  java 8 Ϊ List���ϣ��ṩĬ�Ϸ��� sort(),replaceAll()
		 */
		
		List<String> books = new ArrayList<>();
		
		books.add("java");
		books.add("js");
		books.add("android");
		
		books.sort((o1,o2)->o1.compareTo(o2));
		System.out.println(books);
		
		books.replaceAll(ele-> String.valueOf(ele.length()));
		System.out.println(books);
		
		/**
		 *  �ṩlistIterator������������ǰ����������ͨ��add�������Ԫ��
		 */
		ListIterator<String> listIterator = books.listIterator();
		while(listIterator.hasNext()) {
			String value = listIterator.next();
			if (value.equals("7")) {
				listIterator.add("9");//��ǰԪ�غ������һ��Ԫ��
			}
		}
		System.out.println(books);
		
		/**
		 *  ArrayList,Vector
		 *  	��װһ����̬�������ٷ�������飬���·��������С
		 *  		1��ensureCapacity(minCapacity) ���鳤�����Ӵ��ڻ����minCapacity
		 *  		2��trimToSize() ʹ���鳤��Ϊ��ǰԪ�صĸ���
		 *  
		 *  ArrayList�����̰߳�ȫ�ģ�Vector���̰߳�ȫ�ģ�Stack��Vector���࣬
		 */
		
		/**
		 * 	Queue���У��ӽӿ�Deque������һ����˫�˶��С�
		 * 
		 * 	PriorityQueue���Ƚϱ�׼�Ķ��У�����Ԫ�ص�˳�����Ԫ�ش�С����ͷȡ��������С�ģ���������nullԪ�ء�
		 * 
		 * 	ArrayDeque ��������ʵ�ֵ�˫�˶���
		 * 
		 * 	LinkedList ʵ����Deque�����ɵ�˫�˶��У�Ҳ���Ե�ջ
		 */
	}
	
	
}
