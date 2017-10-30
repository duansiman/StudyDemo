package com.devin.java.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by devin on 2017/5/19.
 */
@RunWith(Parameterized.class)
public class ParamTest {

    private Integer value;

    public ParamTest(Integer value) {
        this.value = value;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> data() {
        Integer[][] data = new Integer[][]{{1},{3},{5},{7}};
        return Arrays.asList(data);
    }

    @Test
    public void test() throws Exception {
        assert this.value < 5;
    }
}
