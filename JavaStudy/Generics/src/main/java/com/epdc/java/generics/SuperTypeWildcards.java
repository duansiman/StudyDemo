package com.epdc.java.generics;

import java.util.List;

/**
 * Created by epdc on 17-1-15.
 */
public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> appls){
        appls.add(new Apple());
        appls.add(new Jonathan());
//        appls.add(new Fruit());  // error
    }

}
