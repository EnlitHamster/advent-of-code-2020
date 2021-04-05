package io.github.enlithamster.five;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.github.enlithamster.DayChallenge;

public class DayFive implements DayChallenge {

  @Override
  public void launch() {

    // Setup
    ArrayList<String> seats = new ArrayList<>();

    try {
      // Reading numbers from input file
      InputStream input = getClass().getResourceAsStream("/resources/five/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) seats.add(fileReader.nextLine());
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // -- PART 1

    // Generating all the passports
    ArrayList<Pass> boardingPasses = new ArrayList<>(seats.stream()
                                                          .map(Pass::new)
                                                          .collect(Collectors.toList()));

    // IDs all positive, so starting from a negative number ensures that
    // maxID will contain the biggest ID found. 
    Integer maxID = boardingPasses.stream()
                                  .map(Pass::UID)
                                  .max(Integer::compare)
                                  .get();
    
    System.out.println("The maximum pass ID is " + maxID + ".");

    // -- PART 2

    System.out.println("The open seats are:");

    ArrayList<Integer> seatNumbers = new ArrayList<>(boardingPasses.stream()
                                                                    .map(Pass::UID)
                                                                    .collect(Collectors.toList()));

    IntStream.range(0, Pass.MAX_ID)
             .boxed()
             .filter(i -> !seatNumbers.contains(i))
             .forEach(System.out::println);

  }
  
}
