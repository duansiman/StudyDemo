package com.demo.paramtype;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 	java 7 泛型菱形语法，对象的构造器后面不需要带泛型，只要有<>
		 * 
		 * 	从泛型派生子类，接口、父类不能再包含类型形参（泛型）
		 * 
		 * 	ArrayList<String> 系统并没有生成新的class文件，不会当做新类处理
		 * 
		 * 	ArrayList<String> 不能当成ArrayList<Object>使用
		 * 
		 * 	如果Foo 是Bar类，那么G<Foo>并不是G<Bar>子类型，但Foo[] 是Bar[]子类型
		 */
		
		/**
		 * 	类型通配符？
		 * 	List<?> 它的元素可以匹配任何类型，是各种泛型List的父类，并不能把元素加入到其中
		 * 	
		 * 	类型通配符的上限
		 * 	List<? extends Bar> 表示是Bar的子类
		 * 
		 * 	类型形参的上限
		 * 	Bar<T extends Number> 表示是Number的子类
		 * 	设定多个上限，（至多一个父类，多个接口上限）
		 * 	Bar<T extends Number & java.io.Serializable>
		 * 
		 * 	通配符下限
		 * 	<? super Bar> 必须是Bar本身，或者是Bar的父类
		 */
		
		/**
		 * 	泛型方法
		 * 		格式：修饰符 <T, S> 返回值类型 方法名（形参） 调用方法无需传入类型
		 * 
		 * 	泛型构造器
		 * 		public <T> Foo(T t)
		 * 		如果指定了泛型构造器的实际类型，则这时不可以使用泛型菱形语法
		 */
		
		/**
		 * 	java 8 增加类型判断
		 * 		1、通过调用方法的上下文，判断类型参数的目标类型
		 * 		2、在方法调用链中，推断得到类型参数传递给最后一个方法
		 */
		// 根据赋值左边，得知右边是String
		MyUtils<String> ls = MyUtils.nil();
		
		//根据第一个参数 ，推断出Integer
		MyUtils.cons(43, MyUtils.<Integer>nil());
		
		MyUtils.cons(43, MyUtils.<Integer>nil());
		
		MyUtils.copy(new ArrayList<Number>(), new ArrayList<Integer>());
		
		/**
		 *  泛型擦除和转换
		 *  	1、没有指定泛型类型的实际类型，该类型参数称为原始类型(raw type) 默认类型参数指定的第一个上限类型
		 *  		List list = new ArrayList(); //元素类型是Object
		 *  
		 *  	2、List list = new ArrayList<Integer>;//丢失了原来Integer类型，称为擦除
		 *  
		 */
		
		List<Integer> li = new ArrayList<>();
		li.add(6);
		
		List ll = li;
		System.out.println(ll.get(0));
		
		List<String> lll = ll;
		String s = lll.get(0);
		System.out.println(lll.get(0));//报错
		
		/**
		 *  泛型与数组
		 */
//		List<String>[] lsa = new List<String>[10];
		
	}

}
