package io.github.enlithamster.six;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Group {

  private HashMap<Character, Integer> answers;

  private Integer groupLength = 0;

  public Group(String doc) {
    answers = generateAnswerSheet();
    String[] entries = doc.split(" ");
    groupLength = entries.length;
    for (String entry : entries)
      for (Character c : entry.toCharArray())
        answers.put(c, answers.get(c) + 1);
  }

  public Integer countAnyYes() {
    return Long.valueOf(answers.entrySet().stream()
                                          .filter(e -> e.getValue() > 0)
                                          .count()).intValue();
  }

  public Integer countAllYes() {
    return Long.valueOf(answers.entrySet().stream()
                                          .filter(e -> e.getValue() == groupLength)
                                          .count()).intValue();
  }

  private static HashMap<Character, Integer> generateAnswerSheet() {
    HashMap<Character, Integer> mapCharInt = new HashMap<>();
    IntStream.range((int) 'a', ((int) 'z') + 1)
             .boxed()
             .map(i -> (char) i.intValue())
             .forEach(c -> mapCharInt.put(c, 0));
    return mapCharInt;
  }
  
}
