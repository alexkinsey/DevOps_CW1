package com.alex;

public class Dec2Hex {

  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("Error: Please enter one decimal number to be processed.");
    }

    int decimalValue = 0;

    try {
      decimalValue = Integer.parseInt(args[0]);
      
      if (decimalValue < 0) {
        throw new IllegalArgumentException("Error: Please enter a positive decimal number to be processed.");
      }

      String hexadecimal = decimalToHex(decimalValue);
      System.out.println("Hexadecimal representation is: " + hexadecimal);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Error: Please enter a valid decimal number to be processed.");
    }
  }

  public static String decimalToHex(int decimalValue) {
    char[] ch = {
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      'A',
      'B',
      'C',
      'D',
      'E',
      'F',
    };
    int rem;
    StringBuilder hexadecimal = new StringBuilder();

    System.out.println(
      "Converting the Decimal Value " + decimalValue + " to Hex..."
    );

    if (decimalValue == 0) {
      return "0";
    }

    while (decimalValue != 0) {
      rem = decimalValue % 16;
      hexadecimal.insert(0, ch[rem]);
      decimalValue = decimalValue / 16;
    }

    return hexadecimal.toString();
  }
}
