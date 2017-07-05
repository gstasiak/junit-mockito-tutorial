package com.comarch.jm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RuleExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throwsNullPointerExceptionIfValueIsNull() {
        exception.expect(NullPointerException.class);
        //exception.expectMessage("null!");

        Long value = null;
        value.toString();
    }
}
