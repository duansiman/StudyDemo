package com.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		/**
		 *  java 8 为 List集合，提供默认方法 sort(),replaceAll()
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
		 *  提供listIterator方法，增加向前迭代，可以通过add方法添加元素
		 */
		ListIterator<String> listIterator = books.listIterator();
		while(listIterator.hasNext()) {
			String value = listIterator.next();
			if (value.equals("7")) {
				listIterator.add("9");//当前元素后面添加一个元素
			}
		}
		System.out.println(books);
		
		/**
		 *  ArrayList,Vector
		 *  	封装一个动态，允许再分配的数组，重新分配数组大小
		 *  		1、ensureCapacity(minCapacity) 数组长度增加大于或等于minCapacity
		 *  		2、trimToSize() 使数组长度为当前元素的个数
		 *  
		 *  ArrayList不是线程安全的，Vector是线程安全的，Stack是Vector子类，
		 */
		
		/**
		 * 	Queue队列，子接口Deque，代表一个“双端队列”
		 * 
		 * 	PriorityQueue，比较标准的队列，保存元素的顺序而是元素大小，从头取出来是最小的，不允许有null元素。
		 * 
		 * 	ArrayDeque 基于数组实现的双端队列
		 * 
		 * 	LinkedList 实现了Deque，即可当双端队列，也可以当栈
		 */
	}
	
	
}
