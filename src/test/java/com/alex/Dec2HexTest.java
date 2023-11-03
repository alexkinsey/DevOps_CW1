package com.alex;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class Dec2HexTest {

  private ByteArrayOutputStream outContent;
  private PrintStream originalOut;

  @BeforeEach
  public void setUp() throws Exception {
    outContent = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void tearDown() throws Exception {
    System.setOut(originalOut);
  }

  @Test
  public void testConvert255ToHex() {
    Dec2Hex.main(new String[] { "255" });
    assertEquals(
      "Converting the Decimal Value 255 to Hex...\nHexadecimal representation is: FF",
      outContent.toString().trim()
    );
  }

  @Test
  public void testConvert0ToHex() {
    Dec2Hex.main(new String[] { "0" });
    assertEquals(
      "Converting the Decimal Value 0 to Hex...\nHexadecimal representation is: 0",
      outContent.toString().trim()
    );
  }

  @Test
  public void testNegativeDecimalValue() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        Dec2Hex.main(new String[] { "-255" });
      }
    );

    assertEquals(
      "Error: Please enter a valid decimal number to be processed.",
      exception.getMessage()
    );
  }

  @Test
  public void testLargeDecimalValue() {
    Dec2Hex.main(new String[] { "2147483647" }); // Maximum integer value
    assertEquals(
      "Converting the Decimal Value 2147483647 to Hex...\nHexadecimal representation is: 7FFFFFFF",
      outContent.toString().trim()
    );
  }

  @Test
  public void testNonIntegerValue() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        Dec2Hex.main(new String[] { "10.5" });
      }
    );

    assertEquals(
      "Error: Please enter a valid decimal number to be processed.",
      exception.getMessage()
    );
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
      "Error: Please enter one decimal number to be processed.",
      exception.getMessage()
    );

    System.setOut(originalOut);
  }

  @Test
  public void testNonDecimalArgument() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        Dec2Hex.main(new String[] { "Ten" });
      }
    );

    assertEquals(
      "Error: Please enter a valid decimal number to be processed.",
      exception.getMessage()
    );

    System.setOut(originalOut);
  }
}
