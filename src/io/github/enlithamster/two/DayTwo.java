package io.github.enlithamster.two;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import io.github.enlithamster.DayChallenge;

public class DayTwo implements DayChallenge {

  public void launch() {

    // Setup
    ArrayList<PasswordEntry> passwords = new ArrayList<>();

    try {
      // Reading passwords from input file
      InputStream input = getClass().getResourceAsStream("/resources/two/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) passwords.add(new PasswordEntry(fileReader.nextLine()));
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // -- PART 1

    // Counting bound compliant passwords
    Integer countCompliant = Long.valueOf(passwords.stream().filter(PasswordEntry::isBoundCompliant).count()).intValue();
    System.out.println("There are " + countCompliant + " bound compliant passwords.");

    // -- PART 2

    // Count position compliant passwords
    countCompliant = Long.valueOf(passwords.stream().filter(PasswordEntry::isPositionCompliant).count()).intValue();
    System.out.println("There are " + countCompliant + " position compliant passwords.");

  }

}
