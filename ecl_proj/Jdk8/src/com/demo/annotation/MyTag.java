package com.demo.annotation;

public @interface MyTag {

	String name() default "����";
	int age() default 21;
	
}
