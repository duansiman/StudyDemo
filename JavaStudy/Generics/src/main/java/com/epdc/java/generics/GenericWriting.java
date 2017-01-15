package com.epdc.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epdc on 17-1-15.
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();

    static List<Fruit> fruits = new ArrayList<>();

    static void f1(){
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
        fruits.stream().forEach(fruit -> System.out.println(fruit));
    }

    public static void main(String[] args){
        f1();
    }
}
