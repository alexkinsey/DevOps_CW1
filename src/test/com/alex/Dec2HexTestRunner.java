package com.alex;

import com.alex.Dec2Hex;

public class Dec2HexTestRunner {

  public static void main(String[] args) {
    testConvertToHex();
  }

  static void testConvertToHex() {
    String result = Dec2Hex.decimalToHex(255);
    assert "FF".equals(result) : "Expected FF, but got " + result;
  }
}
