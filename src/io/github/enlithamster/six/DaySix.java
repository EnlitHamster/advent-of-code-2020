package io.github.enlithamster.six;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import io.github.enlithamster.DayChallenge;

public class DaySix implements DayChallenge {

  @Override
  public void launch() {

    // Setup
    ArrayList<String> lines = new ArrayList<>();

    try {
      // Reading numbers from input file
      InputStream input = getClass().getResourceAsStream("/resources/six/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) lines.add(fileReader.nextLine());
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    ArrayList<Group> groups = new ArrayList<>();
    String[] docs = String.join(" ", lines).split("  ");
    for (String doc : docs)
      groups.add(new Group(doc));

    // -- PART 1

    Integer countAnyYes = groups.stream()
                                .map(Group::countAnyYes)
                                .mapToInt(i -> i)
                                .sum();
    System.out.println("The sum of all of the answers with Any qualification is " + countAnyYes + ".");

    // -- PART 2

    Integer countAllYes = groups.stream()
                                .map(Group::countAllYes)
                                .mapToInt(i -> i)
                                .sum();
    System.out.println("The sum of all of the answers with All qualification is " + countAllYes + ".");

  }
  
}
