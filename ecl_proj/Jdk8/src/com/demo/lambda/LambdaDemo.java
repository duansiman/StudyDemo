package com.demo.lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		/**
		 * 指定形参 (args)
		 * 方法代码块实现 {}
		 */
		LambdaInterface lambdaInterface = (a)->{
			System.out.println(a);
		};
		
		lambdaInterface.test("hello world");
		
		lambdaInterface.test2();
		
		LambdaInterface.test3();
		
		/**
		 * 一个形参时，可以省略()
		 * 只有一条语句时，可以省略{}, 如果是return语句，可以省略return
		 */
		LambdaInterface2 lambdaInterface2 = value -> value;
		
		System.out.println(lambdaInterface2.test(100));
		
		/**
		 *  赋值给对象时，目标类型必须是明确的函数式接口，也可以强制转换
		 */
		Runnable run = ()->{
			System.out.println("hello runnable");
		};
		new Thread(run).start();
		
		Object obj = (Runnable)()->{
			System.out.println("hello runnable");
		};
		
		/**
		 *  内部类和Lambda代码块访问外部变量时，不需要加effectively final关键字，jdk会默认它已经加上 effectively final, 所以不能被修改
		 *  
		 *  Lambda代码块，不能代码函数式接口的默认方法
		 */
		String name = "李四";
		lambdaInterface = (value)-> {
			System.out.println(value);
			System.out.println(name);
			LambdaInterface.test3();
		};
		lambdaInterface.test("是吧");
	}
	
}
