package io.github.enlithamster;

import java.io.File;
import java.util.Scanner;

import io.github.enlithamster.one.DayOne;
import io.github.enlithamster.two.DayTwo;

public class Main {

  public static void main(String[] args) {

    // Menu printing
    System.out.print(
    "by Sandro Massa (aka EnlitHamster, EnlitOwl)\n"
    +   "\n"
    +   "[1]\tReport Repair\n"
    +   "[2]\tPassword Philosophy\n"
    +   "\n"
    +   "> "
    );

    // Input catching
    Scanner input = new Scanner(System.in);
    int selection = input.nextInt();
    input.close();

    // Execution of correct day code
    switch (selection) {
      case 1: (new DayOne()).launch();
      case 2: (new DayTwo()).launch();
    }

  }

}
