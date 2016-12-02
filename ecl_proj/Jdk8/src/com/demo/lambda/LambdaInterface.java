package com.demo.lambda;

/**
 * FunctionalInterface ����Ϊ����ʽ�ӿ�
 * ����ʽ�ӿڣ�ֻ�ܴ���һ������ķ���
 * @author epdc
 *
 */
@FunctionalInterface
public interface LambdaInterface {
	void test(String value);
	
	/**
	 * ����Ĭ�Ϸ�����������߷���ʵ��
	 */
	default void test2(){
		System.out.println("test2");
	}
	
	/**
	 * �ýӿڵ�ʵ����û�����õ���ֻ��ͨ��LambdaInterface�ӿ������ã�����ͨ�಻һ��
	 */
	public static void test3(){
		System.out.println("test3");
	}
}
