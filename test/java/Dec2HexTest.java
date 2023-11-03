package com.alex;

import static org.junit.Assert.*;
import org.junit.Test;

public class Dec2HexTest {

    @Test
    public void validInputTest() {
        String hex = Dec2Hex.convertToHex(128);
        assertEquals("80", hex);
    }

    @Test
    public void anotherValidInputTest() {
        String hex = Dec2Hex.convertToHex(255);
        assertEquals("FF", hex);
    }

    @Test
    public void nonIntegerInputTest() {
        String result = Dec2Hex.runConversion("abc");
        assertEquals("Error: Please enter a valid decimal number to be processed.", result);
    }

    @Test
    public void noInputTest() {
        String result = Dec2Hex.runConversion("");
        assertEquals("Error: Please enter one decimal number to be processed.", result);
    }
}
