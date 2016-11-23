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
		 * 	集合有两个接口派生：Collection和Map
		 * 
		 * 	Set 无序集合，元素不可重复
		 * 	List 有序集合
		 * 
		 * 	asList返回的集合，没有add和remove方法的
		 */
		
		List<String> list = Arrays.asList(new String[]{"hell", "world"});
		
		//Lambda表达式，遍历集合
		list.forEach((e)->System.out.println(e));
		
		/**
		 * 	Iterator迭代Collection集合，集合里的元素不能改变，foreach也是一样。Iterator使用的快速失败机制
		 * 	但能通过iterator.remove方法删除，上一次next方法返回的元素
		 */
		
		/**
		 *  java 8 增加Predicate集合，批量删除符合条件的元素
		 */
		List<String> list2 = new ArrayList<>();
		list2.add("hell");
		list2.add("world");
		list2.removeIf(ele-> "hell".equals(ele));
		list2.forEach((e)->System.out.println(e));
		
		/**
		 *  java 8 新增Stream操作集合，代表多个支持串行和并行聚集操作的元素
		 */
		
		IntStream is = IntStream.builder()
				.add(39)
				.add(334)
				.add(-23)
				.add(2)
				.build();
		
		//聚集方法，每一次只能调用一个,否则stream has already been operated upon or closed
		System.out.println(is.max().getAsInt());
		System.out.println(is.min().getAsInt());
	}
	
}
