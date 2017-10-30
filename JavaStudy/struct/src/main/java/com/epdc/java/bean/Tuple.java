package com.epdc.java.bean;

/**
 * Created by epdc on 17-4-30.
 */
public class Tuple<L,R,S> {

    public L left;
    public R right;
    public S sum;

    @Override
    public String toString() {
        return left + ":" + right + ":" + sum;
    }
}
