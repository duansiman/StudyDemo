package com.epdc.junit.asserts;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;

public class AssertTest {

	@Test
	public void test(){
		//assertThat 它需要的参数是一个可选的失败消息，实际返回值和一个 Matcher 对象
		assertThat("albumen", both(containsString("a")).and(containsString("b")));
		assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}
	
}
