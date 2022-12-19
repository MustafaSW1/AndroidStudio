package com.example.unittest;

import org.junit.Test;

import static org.junit.Assert.*;


public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void minus(){
        Calculator c = new Calculator();
        double R = c.sub(10.0,2.0);
        assertEquals("a",8.0,R,0.0);
    }

    public void plus(){
        Calculator c = new Calculator();
        double R = c.add(10.0,2.0);
        assertEquals("a",12.0,R,0.0);
    }
}