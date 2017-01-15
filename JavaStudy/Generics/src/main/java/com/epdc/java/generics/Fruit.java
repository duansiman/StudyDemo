package com.epdc.java.generics;

/**
 * Created by epdc on 17-1-15.
 */
public class Fruit {

    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit{
    @Override
    public String toString() {
        return "Apple";
    }
}

class Jonathan extends Apple{}

class Orange extends Fruit{}
