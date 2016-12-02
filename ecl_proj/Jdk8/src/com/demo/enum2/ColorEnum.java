package com.demo.enum2;

/**
 * 
 * 	1、enum定义，非抽象的枚举类，默认会使用final修饰
 * 	2、构造器只能使用private修饰
 * 	3、所有实例必须在第一个显示列出
 * 
 * @author epdc
 *
 */

public enum ColorEnum {

	Red("红"), Green("绿"), Blue("蓝");
	
	private final String name;
	
//	{
//		name = "红";
//	}
	
	private  ColorEnum(String value) {
		name = value;
	}
	
	public String getName() {
		return name;
	}
	
}
