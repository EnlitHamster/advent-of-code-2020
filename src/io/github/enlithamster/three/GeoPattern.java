package io.github.enlithamster.three;

import java.util.ArrayList;

public class GeoPattern {
    
  private static final Character C_TREE = '#';

  private final Boolean[][] pattern;

  // Grid dimensions
  public final Integer yLength;
  public final Integer xLength;

  public GeoPattern(ArrayList<String> strPattern) {
    // We assume the strPattern entries have all same length
    yLength = strPattern.size();
    xLength = strPattern.get(0).length();
    // First index is y axis, second is x axis for construction
    pattern = new Boolean[yLength][xLength];

    for (Integer y = 0; y.compareTo(yLength) < 0; ++y)
      for (Integer x = 0; x.compareTo(xLength) < 0; ++x)
        pattern[y][x] = C_TREE.equals(strPattern.get(y).charAt(x));
  }

  public Boolean isTree(Integer x, Integer y) {
    return pattern[y % yLength][x % xLength];
  }

}
