package com.alex;

import com.alex.Dec2Hex;

public class Dec2HexTestRunner {

  public static void main(String[] args) {
    testDecimalToHex();
  }

  static void testDecimalToHex() {
    assert "FF".equals(Dec2Hex.decimalToHex(255)) : "Expected FF, but got " + Dec2Hex.decimalToHex(255);
    assert "0".equals(Dec2Hex.decimalToHex(0)) : "Expected 0, but got " + Dec2Hex.decimalToHex(0);
    
    try {
        Dec2Hex.decimalToHex(-1);
        assert false : "Expected an exception for negative input, but got none";
    } catch (IllegalArgumentException e) {
        // Expected, so do nothing
    }

    assert "7FFFFFFF".equals(Dec2Hex.decimalToHex(Integer.MAX_VALUE)) : "Expected 7FFFFFFF, but got " + Dec2Hex.decimalToHex(Integer.MAX_VALUE);
    assert "64".equals(Dec2Hex.decimalToHex(100)) : "Expected 64, but got " + Dec2Hex.decimalToHex(100);
}
}
