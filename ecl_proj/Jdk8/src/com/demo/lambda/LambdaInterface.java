package com.demo.lambda;

/**
 * FunctionalInterface 申明为函数式接口
 * 函数式接口，只能存在一个抽象的方法
 * @author epdc
 *
 */
@FunctionalInterface
public interface LambdaInterface {
	void test(String value);
	
	/**
	 * 定义默认方法，可以提高方法实现
	 */
	default void test2(){
		System.out.println("test2");
	}
	
	/**
	 * 该接口的实例，没法调用到，只能通过LambdaInterface接口名调用，和普通类不一样
	 */
	public static void test3(){
		System.out.println("test3");
	}
}
