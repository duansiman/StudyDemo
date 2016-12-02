package com.demo.annotation;

import java.lang.reflect.Method;

public class ProcessorTest {

	public static void process(String clazz) throws SecurityException, ClassNotFoundException {
		int passed = 0, failed = 0;
		
		for (Method m : Class.forName(clazz).getMethods()) {
			if (m.isAnnotationPresent(Testable.class)) {
				try {
					m.invoke(null);
					passed++;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(m+"‘À–– ß∞‹");
					failed++;
				}
			}
		}
		
		System.out.println(passed+":"+failed);
	}
	
}
