package com.demo.annotation;

public class AnnotationDemo {

	public static void main(String[] args) {
		/**
		 *  ע�⣬����һ�������ǣ������ڱ��룬����أ�����ʱ����ȡ����ִ����Ӧ�Ĵ���, Ҫ�����ñ����ṩע�⴦����
		 *  	��Щ���ͨ�������ȡ��Ȼ��������Ӧ����
		 *  
		 *  @Override ָ����������
		 *  
		 *  @Deprecated ����ѹ�ʱ
		 *  
		 *  @SuppressWarnings ���Ʊ���������
		 *  
		 *  @SafeVarargs java 7����Ⱦ���棬 ���磺�������͵Ķ���ֵ��һ�������͵ı���
		 *  
		 *  @FunctionallInterface ����ʽ�ӿ�
		 */
		
		/**
		 *  jdk ԪAnnotation	
		 *  
		 *  ����������Annotation����
		 *  
		 *  @Retention �����ε�Annotation���Ա����೤ʱ�䣬����һ��RetentionPolicy����value��Ա����������ʹ��name=value��ʽ
		 *  
		 *  @Target �����ε�Annotation������������Щ����Ԫ
		 *  
		 *  @document ������Annotation��Annotation�౻javadoc������ȡ���ĵ����ĵ��л���ʾ�����ε�Annotation
		 *  
		 *  @Inherited ������Annotation���м̳��ԣ������ε���������Զ���@Xxx����
		 */
		System.out.println(Sub.class.isAnnotationPresent(Inheritable.class));
	}
	
}
