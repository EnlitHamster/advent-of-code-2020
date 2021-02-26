package io.github.enlithamster.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.io.InputStream;

import io.github.enlithamster.DayChallenge;

public class DayOne implements DayChallenge {

  @Override
  public void launch() {

    // Setup
    ArrayList<Integer> numbers = new ArrayList<>();

    try {
      // Reading numbers from input file
      InputStream input = getClass().getResourceAsStream("/resources/one/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextInt()) numbers.add(fileReader.nextInt());
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // -- PART 1

    // Sorting the numbers
    Collections.sort(numbers);

    // Searching for two keys
    Integer[] keys = getBinaryKeys(numbers, 2020);
    if (keys != null) System.out.println("The searched numbers are " + keys[0] + " and " + keys[1] + ".\nThe answer is " + (keys[0] * keys[1]) + ".");
    else System.out.println("No keys found.");

    // -- PART 2

    // Searching for three keys
    keys = getTernaryKeys(numbers, 2020);
    if (keys != null) System.out.println("The searched numbers are " + keys[0] + ", " + keys[1] + " and " + keys[2] + ".\nThe answer is " + (keys[0] * keys[1] * keys[2]) + ".");
    else System.out.println("No keys found.");

  }

  /**
  * Binary search algorithm for the two keys.
  *
  * @param numbers List of sorted numbers to search
  * @param target Target sum to find
  * @return An array with the two keys, null if not found
  */
  private Integer[] getBinaryKeys(List<Integer> numbers, Integer target) {
    // Unsuccessful search
    if (numbers.isEmpty()) return null;

    Integer key1 = numbers.get(0);
    Integer key2 = getBinaryKeys(target, key1, numbers);
    if (key2 != null) return new Integer[] {key1, key2};
    else return getBinaryKeys(numbers.subList(1, numbers.size()), target);
  }

  private Integer getBinaryKeys(Integer target, Integer key1, List<Integer> numbers) {
    // Unsuccessful search
    if (numbers.isEmpty()) return null;

    Integer pivot = numbers.size() / 2;
    Integer key2 = numbers.get(pivot);
    Integer attempt = key1 + key2;
    if (attempt.equals(target)) return key2;
    else if (attempt.compareTo(target) > 0) return getBinaryKeys(target, key1, numbers.subList(0, pivot));
    else return getBinaryKeys(target, key1, numbers.subList(pivot + 1, numbers.size()));
  }

  /**
  * Binary search algorithm for the three keys.
  *
  * @param numbers List of sorted numbers to search
  * @param target Target sum to find
  * @return An array with the three keys, null if not found
  */
  private Integer[] getTernaryKeys(List<Integer> numbers, Integer target) {
    // Unsuccessful search
    if (numbers.isEmpty()) return null;

    Integer key1 = numbers.get(0);
    Integer binaryTarget = target - key1;
    Integer[] keys = getBinaryKeys(numbers.subList(1, numbers.size()), binaryTarget);
    if (keys != null) return new Integer[] {key1, keys[0], keys[1]};
    else return getTernaryKeys(numbers.subList(1, numbers.size()), target);
  }

}
