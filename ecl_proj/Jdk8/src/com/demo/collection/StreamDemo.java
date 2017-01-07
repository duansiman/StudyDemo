package com.demo.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamDemo {

	public static void main(String[] args) {
		Stream<Integer> intStream = Stream.of(3, 3, 2, 4, 5, 1, 6, 7, 45, 23);

		/**
		 *  Stream 分中间操作和末端操作。末端操作后Stream就不能再被操作
		 */
		
		
		intStream.filter(i -> i < 5 ? false : true).forEach(i -> System.out.print(i + ", "));
		System.out.println();

		Integer [] strArray = new Integer[] {1,2};
		Stream<Integer> integerStream = Stream.of(strArray);
		integerStream.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		//基本类型
		IntStream.of(new int[]{2, 3}).forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		//转换
		Stream<String> stream = Stream.of("a", "b", "c");
		String[] strArr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(strArr));
		
		stream = Stream.of(strArr);
		List<String> list = stream.collect(Collectors.toList());
		System.out.println(list);
		
		stream = Stream.of(strArr);
		System.out.println(stream.collect(Collectors.joining()));
		
		stream = Stream.of(strArr);
		stream.map(String::toUpperCase).forEach(i -> System.out.print(i + ", "));
		System.out.println();
	}

}
