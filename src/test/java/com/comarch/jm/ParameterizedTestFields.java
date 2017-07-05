package com.comarch.jm;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTestFields {

    //public!
    @Parameter(0)
    public int value1;
    @Parameter(1)
    public int value2;
    @Parameter(2)
    public int result;

    /*public int value1;
    public int value2;
    public int result;

    public ParameterizedTestFields(int value1, int value2, int result) {
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
    }*/

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{2, 2, 4}, {5, 3, 8}, {21, 44, 65}, {1, 1, 1}};
        return Arrays.asList(data);
    }

    @Test
    public void testMultiplyException() {
        MyClass tester = new MyClass();
        assertEquals("Result", result, tester.multiply(value1, value2));
    }

    class MyClass {
        int multiply(int i, int j) {
            return i + j;
        }
    }

}
