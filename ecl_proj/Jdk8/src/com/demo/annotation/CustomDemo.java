package com.demo.annotation;

import java.lang.annotation.Annotation;

public class CustomDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		/**
		 *  使用@interface 关键字定义一个新的Annotation类型
		 *  
		 *  定义成员变量，以无形参的方法形式来声明, 是default 指定初始值
		 */
		
		/**
		 *  提取Annotation信息， java 是Annotation接口代表注解，该接口是所有注解的父接口
		 *  
		 *  java 5 java.lang.reflect 新增AnnotatedElement接口，代表可以接受的程序元素，几个实现类：
		 *  	Class
		 *  	Constructor
		 *  	Field
		 *  	Method
		 *  	Package
		 *  
		 *  java.lang.reflect java 5 该包增加读取运行时Annotation
		 */
		
		//方法Annotation信息, 获取类的
		Annotation[] annotations = Class.forName("com.demo.annotation.CustomDemo").getMethod("info").getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		
		CustomDemo customDemo = new CustomDemo();
		Annotation[] a = customDemo.getClass().getMethod("info").getAnnotations();
		System.out.println(a + ", " + a.length);
		for (Annotation annotation : a) {
			System.out.println("Tag is " + annotation);
			if (annotation instanceof MyTag) {
				System.out.println(((MyTag)annotation).name());
			}
		}
	}
	
	@MyTag(name="张三", age=23)
	public void info(){}
	
}
