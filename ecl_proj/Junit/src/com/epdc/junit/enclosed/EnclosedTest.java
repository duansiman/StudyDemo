package com.epdc.junit.enclosed;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
/**
 * 在内部类中执行测试
 * @author devin
 *
 */
@RunWith(Enclosed.class)
public class EnclosedTest {

	public static class InnerTest {
		@Test
		public void testInner() {
			System.out.println("test inner");
		}
	}
	
	@Test
	public void testOuter(){
		System.out.println("test outer");
	}
	
}
