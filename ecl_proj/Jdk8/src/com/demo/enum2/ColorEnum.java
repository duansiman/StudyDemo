package com.demo.enum2;

/**
 * 
 * 	1��enum���壬�ǳ����ö���࣬Ĭ�ϻ�ʹ��final����
 * 	2��������ֻ��ʹ��private����
 * 	3������ʵ�������ڵ�һ����ʾ�г�
 * 
 * @author epdc
 *
 */

public enum ColorEnum {

	Red("��"), Green("��"), Blue("��");
	
	private final String name;
	
//	{
//		name = "��";
//	}
	
	private  ColorEnum(String value) {
		name = value;
	}
	
	public String getName() {
		return name;
	}
	
}
