package com.epdc.java.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by epdc on 17-1-15.
 */
public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1(){
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
    }

    static class Reader<T>{
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2(){
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit fruit = fruitReader.readExact(fruits);
//        Fruit a = fruitReader.readExact(apples);//List<Fruit> 和 List<Apple> 不是父子关系
    }

    static class CovariantRead<T>{
        T readConvariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3(){
        CovariantRead<Fruit> covariantRead = new CovariantRead<>();
        Fruit fruit = covariantRead.readConvariant(fruits);
        Fruit a = covariantRead.readConvariant(apples);
    }

    public static void main(String[] args){
        f1();f2();f3();
    }
}
