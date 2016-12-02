package com.demo.collection;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import com.demo.enum2.ColorEnum;

public class SetDemo {

	public static void main(String[] args) {
		/**
		 *  HashSet 按Hash算法来存储集合中的元素,根据hashCode来计算它的存储位置
		 *  	1、不保证元素排序顺序
		 *  	2、不是同步
		 *  	3、可以是null元素
		 * 
		 * 	判断的两个元素是否相等：
		 * 		通过equals和hashCode的返回值，两个都为true时相等
		 * 
		 * 	LinkedHashSet
		 * 		使用链表维护元素的次序
		 * 
		 * 	TreeSet
		 * 		集合元素处于排序状态，需要红黑树来维护集合元素的次序
		 * 		调用元素的compareTo方法来比较大小，按升序排序，即自然排序，元素需要实现Comparable接口
		 * 		最好添加同一种类型的对象
		 * 
		 * 	EnumSet
		 * 		存储形式非常紧凑，高效
		 * 		为枚举类设计集合类，也是有序的，Enum类定义的顺序
		 * 
		 * 	都不是线程安全的，可以通过Collections.synchronizedSortedSet包装set集合
		 * 
		 */
		
		Set<String> set = new HashSet<>();
		set.add("hello");
		
		EnumSet<ColorEnum> enumSet = EnumSet.allOf(ColorEnum.class);
		System.out.println(enumSet);
	}
	
}
