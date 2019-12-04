package com.test.stringaccumulator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringAccumulatorTest {
    @Test
    public void testWithPositiveCase(){
        StringAccumulator stringAccumulator = new StringAccumulator();
        assertEquals("Total Count",6, stringAccumulator.add("1\n2,3"));
    }

    @Test
    public void testWithMultipleDelimitersWithMoreLength(){
        StringAccumulator stringAccumulator = new StringAccumulator();
        assertEquals("Total Count",6, stringAccumulator.add("//***|@@@@@\\n1***2@@@@@3"));
    }

    @Test
    public void testWithCustomDelimiters(){
        StringAccumulator stringAccumulator = new StringAccumulator();
        assertEquals("Total Count",6, stringAccumulator.add("//*|%\\n1*2%3"));
    }

    @Test
    public void testWithNegatvieNumbers(){
        StringAccumulator stringAccumulator = new StringAccumulator();
        assertEquals("Total Count",3, stringAccumulator.add("1\n2,-3"));
        assertEquals("Negative numbers:",1,stringAccumulator.negativeNumbers.size());
    }
}
