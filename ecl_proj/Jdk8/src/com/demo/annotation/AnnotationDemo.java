package com.demo.annotation;

public class AnnotationDemo {

	public static void main(String[] args) {
		/**
		 *  注解，代表一种特殊标记，可以在编译，类加载，运行时被读取，并执行相应的代码, 要起作用必须提供注解处理工具
		 *  	这些标记通过反射获取，然后做出相应处理
		 *  
		 *  @Override 指定方法覆盖
		 *  
		 *  @Deprecated 标记已过时
		 *  
		 *  @SuppressWarnings 抑制编译器警告
		 *  
		 *  @SafeVarargs java 7堆污染警告， 例如：不带泛型的对象赋值给一个带泛型的变量
		 *  
		 *  @FunctionallInterface 函数式接口
		 */
		
		/**
		 *  jdk 元Annotation	
		 *  
		 *  修饰其他的Annotation定义
		 *  
		 *  @Retention 被修饰的Annotation可以保留多长时间，包含一个RetentionPolicy类型value成员变量，不需使用name=value形式
		 *  
		 *  @Target 被修饰的Annotation能用于修饰那些程序单元
		 *  
		 *  @document 被修饰Annotation，Annotation类被javadoc工具提取成文档，文档中会显示被修饰的Annotation
		 *  
		 *  @Inherited 被修饰Annotation具有继承性，被修饰的类的子类自动被@Xxx修饰
		 */
		System.out.println(Sub.class.isAnnotationPresent(Inheritable.class));
	}
	
}
