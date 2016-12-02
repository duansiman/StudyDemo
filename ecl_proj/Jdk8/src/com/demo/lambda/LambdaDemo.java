package com.demo.lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		/**
		 * ָ���β� (args)
		 * ���������ʵ�� {}
		 */
		LambdaInterface lambdaInterface = (a)->{
			System.out.println(a);
		};
		
		lambdaInterface.test("hello world");
		
		lambdaInterface.test2();
		
		LambdaInterface.test3();
		
		/**
		 * һ���β�ʱ������ʡ��()
		 * ֻ��һ�����ʱ������ʡ��{}, �����return��䣬����ʡ��return
		 */
		LambdaInterface2 lambdaInterface2 = value -> value;
		
		System.out.println(lambdaInterface2.test(100));
		
		/**
		 *  ��ֵ������ʱ��Ŀ�����ͱ�������ȷ�ĺ���ʽ�ӿڣ�Ҳ����ǿ��ת��
		 */
		Runnable run = ()->{
			System.out.println("hello runnable");
		};
		new Thread(run).start();
		
		Object obj = (Runnable)()->{
			System.out.println("hello runnable");
		};
		
		/**
		 *  �ڲ����Lambda���������ⲿ����ʱ������Ҫ��effectively final�ؼ��֣�jdk��Ĭ�����Ѿ����� effectively final, ���Բ��ܱ��޸�
		 *  
		 *  Lambda����飬���ܴ��뺯��ʽ�ӿڵ�Ĭ�Ϸ���
		 */
		String name = "����";
		lambdaInterface = (value)-> {
			System.out.println(value);
			System.out.println(name);
			LambdaInterface.test3();
		};
		lambdaInterface.test("�ǰ�");
	}
	
}
