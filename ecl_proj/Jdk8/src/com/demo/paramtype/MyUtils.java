package com.demo.paramtype;

import java.util.Collection;

public class MyUtils<E> {

	public static <T> void copy(Collection<? super T> dest, Collection<T> src) {
		
	}
	
//	public <T> void copy(Collection<T> dest, Collection<? extends T> src) {
//		
//	}
	
	public static <Z> MyUtils<Z> nil() {
		return null;
	}
	
	public static <Z> MyUtils<Z> cons(Z head, MyUtils<Z> tail) {
		return null;
	}
	
	public <E> E head() {
		return null;
	}
	
	
}
