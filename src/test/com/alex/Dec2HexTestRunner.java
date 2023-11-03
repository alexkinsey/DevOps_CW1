package com.alex;

import com.alex.Dec2Hex;

public class Dec2HexTestRunner {

  public static void main(String[] args) {
    testDecimalToHex();
  }

  static void testDecimalToHex() {
    System.out.println("Check 255 = FF")
    assert "FF".equals(Dec2Hex.decimalToHex(255)) : "Expected FF, but got " + Dec2Hex.decimalToHex(255);

    System.out.println("Check 0 = 0")
    assert "0".equals(Dec2Hex.decimalToHex(0)) : "Expected 0, but got " + Dec2Hex.decimalToHex(0);

    System.out.println("Check max int value = 7FFFFFFF")
    assert "7FFFFFFF".equals(Dec2Hex.decimalToHex(Integer.MAX_VALUE)) : "Expected 7FFFFFFF, but got " + Dec2Hex.decimalToHex(Integer.MAX_VALUE);

    System.out.println("Check 100 = 64")
    assert "64".equals(Dec2Hex.decimalToHex(100)) : "Expected 64, but got " + Dec2Hex.decimalToHex(100);
  }
}
