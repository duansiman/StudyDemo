package com.demo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 	Map �ṩEntry�ڲ����װkey-value��
		 * 	
		 * 	Java 8 ΪMap ��� remove(key, value)ɾ������
		 * 
		 * 	compute ����ԭkey-value����һ����value
		 * 	
		 * 	forEach ��������
		 * 
		 * 	merge ���ԭ��key��Ӧ��valueΪnull������value���ǣ������Ǽ����value����
		 * 
		 * 	putIfAbsent ԭ��valueΪnull�����µ�alue����
		 * 
		 * 	replace�滻ԭ����value����������µ�key-value
		 */
		
		Map<String, String> map = new HashMap<>();
		map.put("key", "value");
		System.out.println(map.toString());
		
//		map.remove("key", "value");
//		System.out.println(map.toString());
		
		map.forEach((key, value)-> System.out.println(key+":"+value));
		
		/**
		 * 	hashtable jdk1.0���У���������elements��keys ���̰߳�ȫ�ģ�������null��Ϊkey��value
		 * 	hashmap	�̲߳���ȫ�ģ�����null��Ϊkey��value
		 * 
		 * 	LinkedHashMap ʹ��˫������ά��key-value���򣬺Ͳ���˳�򱣳�һ��
		 * 
		 * 	Properties ��д�����ļ�����Hashtable���࣬ load���ʼ��������ļ���store���浽�ļ���
		 * 
		 * 	SortedMap�ӿ�TreeMapʵ���࣬��������ݽṹ����֤key-value��������״̬��ʹ��comareTo�����Ƚ�����key�Ƿ����
		 * 	������дequalsʱ��Ҫ���
		 * 
		 * 	WeakHashMap ��������������ã�HashMap����ǿ����
		 * 
		 * 	IdentityHashMap ��������key�Ƿ���ȣ���key1=key2ʱ
		 * 
		 * 	EnumMap ��ö����һ��ʹ�ã�key����Ϊĳö�����ö��ֵ
		 * 
		 * 	hash���������ԣ�
		 * 		�������ӣ�����size/capacity��0��ʾΪ�յ�hash��
		 * 		���ؼ��ޣ�0-1�������������Ӵﵽָ�����ؼ��ޣ�hash���Զ��ɱ�������������ԭ������ŵ���Ͱ�ڣ���Ϊrehashing,Ĭ�ϸ��ؼ���0.75
		 * 
		 */
	}

}
