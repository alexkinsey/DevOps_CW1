package com.alex;

class Dec2Hex {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println(
        "Error: Please enter one decimal number to be processed."
      );
      System.exit(1);
    }

    int decimalValue = 0;

    try {
      decimalValue = Integer.parseInt(args[0]);
      String hexadecimal = decimalToHexadecimal(decimalValue);
      System.out.println("Hexadecimal representation is: " + hexadecimal);
    } catch (NumberFormatException e) {
      System.out.println(
        "Error: Please enter a valid decimal number to be processed."
      );
      System.exit(1);
    }
  }

  public static String decimalToHexadecimal(int decimalValue) {
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

    while (decimalValue != 0) {
      rem = decimalValue % 16;
      hexadecimal.insert(0, ch[rem]);
      decimalValue = decimalValue / 16;
    }

    return hexadecimal.toString();
  }
}
