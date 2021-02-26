package io.github.enlithamster.three;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import io.github.enlithamster.DayChallenge;

public class DayThree implements DayChallenge {

  @Override
  public void launch() {

    // Setup
    ArrayList<String> strPattern = new ArrayList<>();

    try {
      // Reading numbers from input file
      InputStream input = getClass().getResourceAsStream("/resources/three/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) strPattern.add(fileReader.nextLine());
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    GeoPattern pattern = new GeoPattern(strPattern);

    // -- PART 1

    Integer countTrees31 = countTrees(pattern, 3, 1);
    System.out.println("With slope +3 +1 you would encounter " + countTrees31 + " trees.");

    // -- PART 2

    Integer countTrees11 = countTrees(pattern, 1, 1);
    Integer countTrees51 = countTrees(pattern, 5, 1);
    Integer countTrees71 = countTrees(pattern, 7, 1);
    Integer countTrees12 = countTrees(pattern, 1, 2);
    Long answer = countTrees11.longValue() 
                * countTrees31.longValue() 
                * countTrees51.longValue() 
                * countTrees71.longValue() 
                * countTrees12.longValue();

    System.out.println("With slope +1 +1 you would encounter " + countTrees11 + " trees.");
    System.out.println("With slope +5 +1 you would encounter " + countTrees51 + " trees.");
    System.out.println("With slope +7 +1 you would encounter " + countTrees71 + " trees.");
    System.out.println("With slope +1 +2 you would encounter " + countTrees12 + " trees.");
    System.out.println("The answer is " + answer);

  }

  /**
   * Counts the number of trees encountered with a given slope starting
   * from the top-left most cell.
   * 
   * @param pattern The tree disposition pattern
   * @param dX The slope on the X axis of a single step
   * @param dY The slope on the Y axis of a single step
   * @return The number of encountered trees
   */
  public Integer countTrees(GeoPattern pattern, Integer dX, Integer dY) {
    Integer count = 0;
    for (Integer y = 0, x = 0; y.compareTo(pattern.yLength) < 0; y += dY, x += dX)
      if (pattern.isTree(x, y))
        ++count;
    return count;
  }

}
