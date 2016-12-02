package com.devin.java.beans;

import java.util.Objects;

/**
 * Created by devin on 2016/12/1.
 */
public class Foo {

    private Baz baz;
    private int year;
    private String value;
    private Baz baz2;

    public Foo() {
    }

    public Foo(Baz baz) {
        this.baz = baz;
    }

    public Foo(Baz baz, int year, String value){
        this.baz = baz;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return Objects.toString(baz) + ", " + year + ", " + value + ", " + Objects.toString(baz2);
    }

    public void setBaz2(Baz baz2) {
        this.baz2 = baz2;
    }
}
