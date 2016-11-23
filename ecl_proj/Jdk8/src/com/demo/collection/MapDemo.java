package com.demo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 	Map 提供Entry内部类封装key-value对
		 * 	
		 * 	Java 8 为Map 添加 remove(key, value)删除方法
		 * 
		 * 	compute 根据原key-value计算一个新value
		 * 	
		 * 	forEach 遍历方法
		 * 
		 * 	merge 如果原来key对应的value为null，传入value覆盖，否则是计算的value覆盖
		 * 
		 * 	putIfAbsent 原来value为null，用新的alue覆盖
		 * 
		 * 	replace替换原来的value，不会添加新的key-value
		 */
		
		Map<String, String> map = new HashMap<>();
		map.put("key", "value");
		System.out.println(map.toString());
		
//		map.remove("key", "value");
//		System.out.println(map.toString());
		
		map.forEach((key, value)-> System.out.println(key+":"+value));
		
		/**
		 * 	hashtable jdk1.0就有，繁琐方法elements和keys 是线程安全的，不允许null作为key和value
		 * 	hashmap	线程不安全的，允许null作为key和value
		 * 
		 * 	LinkedHashMap 使用双向链表维护key-value次序，和插入顺序保持一致
		 * 
		 * 	Properties 读写属性文件，是Hashtable子类， load访问加载属性文件，store保存到文件中
		 * 
		 * 	SortedMap接口TreeMap实现类，红黑树数据结构，保证key-value处于有序状态，使用comareTo方法比较两个key是否相等
		 * 	所有重写equals时，要相等
		 * 
		 * 	WeakHashMap 保留对象的弱引用，HashMap保持强引用
		 * 
		 * 	IdentityHashMap 处理两个key是否相等，当key1=key2时
		 * 
		 * 	EnumMap 与枚举类一起使用，key必须为某枚举类的枚举值
		 * 
		 * 	hash表，如下属性：
		 * 		负载因子：等于size/capacity，0表示为空的hash表
		 * 		负载极限（0-1），当负载因子达到指定负载极限，hash表自动成倍增加容量，把原来对象放到新桶内，称为rehashing,默认负载极限0.75
		 * 
		 */
	}

}
