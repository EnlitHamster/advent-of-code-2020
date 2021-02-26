package io.github.enlithamster;

import java.io.File;
import java.util.Scanner;

import io.github.enlithamster.one.DayOne;

public class Main {

  public static void main(String[] args) {

    // Menu printing
    System.out.print(
    "by Sandro Massa (aka EnlitHamster, EnlitOwl)\n"
    +   "\n"
    +   "[1] Report Repair\n"
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
    }

  }

}
