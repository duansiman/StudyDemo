package com.epdc.junit.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class A {

	@Test
	public void a() {
		System.out.println("A.a");
	}

	@Category(SlowTests.class)//标记属于的类别
	@Test
	public void b() {
		System.out.println("A.b");
	}
}
