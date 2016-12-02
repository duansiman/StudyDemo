package com.demo.annotation;

import java.lang.annotation.Annotation;

public class CustomDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		/**
		 *  ʹ��@interface �ؼ��ֶ���һ���µ�Annotation����
		 *  
		 *  �����Ա�����������βεķ�����ʽ������, ��default ָ����ʼֵ
		 */
		
		/**
		 *  ��ȡAnnotation��Ϣ�� java ��Annotation�ӿڴ���ע�⣬�ýӿ�������ע��ĸ��ӿ�
		 *  
		 *  java 5 java.lang.reflect ����AnnotatedElement�ӿڣ�������Խ��ܵĳ���Ԫ�أ�����ʵ���ࣺ
		 *  	Class
		 *  	Constructor
		 *  	Field
		 *  	Method
		 *  	Package
		 *  
		 *  java.lang.reflect java 5 �ð����Ӷ�ȡ����ʱAnnotation
		 */
		
		//����Annotation��Ϣ, ��ȡ���
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
	
	@MyTag(name="����", age=23)
	public void info(){}
	
}
