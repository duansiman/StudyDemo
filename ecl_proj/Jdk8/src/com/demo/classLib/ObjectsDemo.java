package com.demo.classLib;

import java.util.Objects;

public class ObjectsDemo {

	public static void main(String[] args) {
		
		String str = null;
		
		/**
		 * java 7 增加Objects 工具类， 是空指针安全的
		 */
		System.out.println(Objects.toString(str));
		
	}
	
}
