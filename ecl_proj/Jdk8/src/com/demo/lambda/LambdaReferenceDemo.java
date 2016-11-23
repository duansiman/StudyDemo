package com.demo.lambda;

public class LambdaReferenceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaReference ref = (value)->Integer.valueOf(value);
		System.out.println(ref.convert("100"));
		
		/**
		 * 	(a,b)->����.�෽��(a,b)
		 *  �������βΣ�ȫ�������෽��������
		 */
		ref = Integer::valueOf;
		System.out.println(ref.convert("99"));
		
		/**
		 * (a,b)->�ض�����.ʵ������(a,b)
		 */
		ref = "hello"::indexOf;
		System.out.println(ref.convert("o"));
		
		/**
		 * (a,b)->a.ʵ������(b)
		 */
		LambdaReference2 ref2 = String::substring;
		System.out.println(ref2.substring("I Love You", 2, 6));
		
		/**
		 * (a)->new ����(a)
		 */
		LambdaReference3 ref3 = StringBuilder::new;
		System.out.println(ref3.str("hello").toString());
	}

}
