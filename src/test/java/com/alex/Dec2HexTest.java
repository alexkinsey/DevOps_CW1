package com.alex;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class Dec2HexTest {

  @Test
  public void testConvertToHex() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Dec2Hex.main(new String[] { "255" });
    assertEquals(
      "Converting the Decimal Value 255 to Hex...\nHexadecimal representation is: FF",
      outContent.toString().trim()
    );

    outContent.reset();
    Dec2Hex.main(new String[] { "0" });
    assertEquals(
      "Converting the Decimal Value 0 to Hex...\nHexadecimal representation is: 0",
      outContent.toString().trim()
    );

    outContent.reset();
    Dec2Hex.main(new String[] { "2147483647" });
    assertEquals(
      "Converting the Decimal Value 2147483647 to Hex...\nHexadecimal representation is: 7FFFFFFF",
      outContent.toString().trim()
    );

    outContent.reset();
    Dec2Hex.main(new String[] { "100" });
    assertEquals(
      "Converting the Decimal Value 100 to Hex...\nHexadecimal representation is: 64",
      outContent.toString().trim()
    );

    System.setOut(originalOut);
  }

  @Test
  public void testNoArguments() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        Dec2Hex.main(new String[] {});
      }
    );

    assertEquals(
      "A single argument is required",
      exception.getMessage()
    );

    System.setOut(originalOut);
  }
}
