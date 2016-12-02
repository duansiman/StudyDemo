package com.demo.enum2;

public class EnumDemo {

	public static void main(String[] args) {
		ColorEnum[] colors = ColorEnum.values();
		for (ColorEnum colorEnum : colors) {
			System.out.println(colorEnum);
			System.out.println(colorEnum.compareTo(ColorEnum.Green));
			System.out.println(colorEnum.name());
			System.out.println(colorEnum.ordinal());
			System.out.println(colorEnum.toString());
			System.out.println(colorEnum.getName());
			System.out.println();
		}
		
		
	}
	
}
