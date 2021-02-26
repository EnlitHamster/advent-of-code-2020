package io.github.enlithamster.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.InputStream;

import io.github.enlithamster.DayChallenge;

public class DayThree implements DayChallenge {

  public void launch() {

    // Setup
    ArrayList<String> pattern = new ArrayList<>();

    try {
      // Reading numbers from input file
      InputStream input = getClass().getResourceAsStream("/resources/three/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) pattern.add(fileReader.nextLine());
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // -- PART 1

  }

}
