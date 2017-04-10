package com.devin.java.junit;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

/**
 * Created by devin on 2017/2/20.
 */
public class UnitilsTest {

    @Test
    public void testReflection(){
        User user1 = new User("devin", "12");
        User user2 = new User("devin", "12");

        ReflectionAssert.assertReflectionEquals(user1, user2);

        Integer[] order1 = {1, 2, 3};
        Integer[] order2 = {3, 1, 2};

        ReflectionAssert.assertLenientEquals(order1, order2);

    }

}
