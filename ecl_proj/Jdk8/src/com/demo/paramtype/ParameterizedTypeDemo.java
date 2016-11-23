package com.demo.paramtype;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 	java 7 ���������﷨������Ĺ��������治��Ҫ�����ͣ�ֻҪ��<>
		 * 
		 * 	�ӷ����������࣬�ӿڡ����಻���ٰ��������βΣ����ͣ�
		 * 
		 * 	ArrayList<String> ϵͳ��û�������µ�class�ļ������ᵱ�����ദ��
		 * 
		 * 	ArrayList<String> ���ܵ���ArrayList<Object>ʹ��
		 * 
		 * 	���Foo ��Bar�࣬��ôG<Foo>������G<Bar>�����ͣ���Foo[] ��Bar[]������
		 */
		
		/**
		 * 	����ͨ�����
		 * 	List<?> ����Ԫ�ؿ���ƥ���κ����ͣ��Ǹ��ַ���List�ĸ��࣬�����ܰ�Ԫ�ؼ��뵽����
		 * 	
		 * 	����ͨ���������
		 * 	List<? extends Bar> ��ʾ��Bar������
		 * 
		 * 	�����βε�����
		 * 	Bar<T extends Number> ��ʾ��Number������
		 * 	�趨������ޣ�������һ�����࣬����ӿ����ޣ�
		 * 	Bar<T extends Number & java.io.Serializable>
		 * 
		 * 	ͨ�������
		 * 	<? super Bar> ������Bar����������Bar�ĸ���
		 */
		
		/**
		 * 	���ͷ���
		 * 		��ʽ�����η� <T, S> ����ֵ���� ���������βΣ� ���÷������贫������
		 * 
		 * 	���͹�����
		 * 		public <T> Foo(T t)
		 * 		���ָ���˷��͹�������ʵ�����ͣ�����ʱ������ʹ�÷��������﷨
		 */
		
		/**
		 * 	java 8 ���������ж�
		 * 		1��ͨ�����÷����������ģ��ж����Ͳ�����Ŀ������
		 * 		2���ڷ����������У��ƶϵõ����Ͳ������ݸ����һ������
		 */
		// ���ݸ�ֵ��ߣ���֪�ұ���String
		MyUtils<String> ls = MyUtils.nil();
		
		//���ݵ�һ������ ���ƶϳ�Integer
		MyUtils.cons(43, MyUtils.<Integer>nil());
		
		MyUtils.cons(43, MyUtils.<Integer>nil());
		
		MyUtils.copy(new ArrayList<Number>(), new ArrayList<Integer>());
		
		/**
		 *  ���Ͳ�����ת��
		 *  	1��û��ָ���������͵�ʵ�����ͣ������Ͳ�����Ϊԭʼ����(raw type) Ĭ�����Ͳ���ָ���ĵ�һ����������
		 *  		List list = new ArrayList(); //Ԫ��������Object
		 *  
		 *  	2��List list = new ArrayList<Integer>;//��ʧ��ԭ��Integer���ͣ���Ϊ����
		 *  
		 */
		
		List<Integer> li = new ArrayList<>();
		li.add(6);
		
		List ll = li;
		System.out.println(ll.get(0));
		
		List<String> lll = ll;
		String s = lll.get(0);
		System.out.println(lll.get(0));//����
		
		/**
		 *  ����������
		 */
//		List<String>[] lsa = new List<String>[10];
		
	}

}
