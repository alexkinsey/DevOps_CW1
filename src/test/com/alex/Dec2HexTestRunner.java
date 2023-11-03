package com.alex;

import com.alex.Dec2Hex;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dec2HexTestRunner {

  public static void main(String[] args) {
    System.out.println("Running tests...");

    System.out.println("Testing decimal to hexadecimal conversion...");
    testConvertToHex();

    System.out.println("Testing no arguments...");
    testNoArguments();

    System.out.println("All tests passed!");
  }

  static void testConvertToHex() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Dec2Hex.main(new String[] { "255" });
    assert "FF".equals(outContent.toString().trim()) : "Expected FF, but got " +
    outContent.toString();

    outContent.reset();
    Dec2Hex.main(new String[] { "0" });
    assert "0".equals(outContent.toString().trim()) : "Expected 0, but got " +
    outContent.toString();

    outContent.reset();
    Dec2Hex.main(new String[] { "2147483647" });
    assert "7FFFFFFF".equals(
        outContent.toString().trim()
      ) : "Expected 7FFFFFFF, but got " + outContent.toString();

    outContent.reset();
    Dec2Hex.main(new String[] { "100" });
    assert "64".equals(outContent.toString().trim()) : "Expected 64, but got " +
    outContent.toString();

    System.setOut(originalOut);
  }

  static void testNoArguments() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Dec2Hex.main(new String[] {});
    assert "Error: Please enter one decimal number to be processed.".equals(
        outContent.toString().trim()
      ) : "Expected error message, but got " + outContent.toString();

    System.setOut(originalOut);
  }
}
