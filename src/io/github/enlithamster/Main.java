package io.github.enlithamster;

import java.util.Scanner;

import io.github.enlithamster.four.DayFour;
import io.github.enlithamster.one.DayOne;
import io.github.enlithamster.three.DayThree;
import io.github.enlithamster.two.DayTwo;
import io.github.enlithamster.five.DayFive;

public class Main {

  public static void main(String[] args) {

    // Menu printing
    System.out.print( "by Sandro Massa (aka EnlitHamster, EnlitOwl)\n"
                    + "\n"
                    + "[1]\tReport Repair\n"
                    + "[2]\tPassword Philosophy\n"
                    + "[3]\tToboggan Trajectory\n"
                    + "[4]\tPassport Processing\n"
                    + "[5]\tBinary Boarding\n"
                    + "\n"
                    + "> " );

    // Input catching
    Scanner input = new Scanner(System.in);
    int selection = input.nextInt();
    input.close();

    // Execution of correct day code
    switch (selection) {
      case 1: (new DayOne()).launch();
      case 2: (new DayTwo()).launch();
      case 3: (new DayThree()).launch();
      case 4: (new DayFour()).launch();
      case 5: (new DayFive()).launch();
    }

  }

}
