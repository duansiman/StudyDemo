package com.demo.lambda;

public class LambdaReferenceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaReference ref = (value)->Integer.valueOf(value);
		System.out.println(ref.convert("100"));
		
		/**
		 * 	(a,b)->类名.类方法(a,b)
		 *  方法里形参，全部传给类方法当参数
		 */
		ref = Integer::valueOf;
		System.out.println(ref.convert("99"));
		
		/**
		 * (a,b)->特定对象.实例方法(a,b)
		 */
		ref = "hello"::indexOf;
		System.out.println(ref.convert("o"));
		
		/**
		 * (a,b)->a.实例方法(b)
		 */
		LambdaReference2 ref2 = String::substring;
		System.out.println(ref2.substring("I Love You", 2, 6));
		
		/**
		 * (a)->new 类名(a)
		 */
		LambdaReference3 ref3 = StringBuilder::new;
		System.out.println(ref3.str("hello").toString());
	}

}
