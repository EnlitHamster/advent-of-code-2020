package io.github.enlithamster.four;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import io.github.enlithamster.DayChallenge;

public class DayFour implements DayChallenge {

  @Override
  public void launch() {

    // Setup
    ArrayList<String> lines = new ArrayList<>();

    try {
      // Reading numbers from input file
      InputStream input = getClass().getResourceAsStream("/resources/four/input.txt");
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) lines.add(fileReader.nextLine());
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Generating the documents from String representation
    ArrayList<Document> documents = new ArrayList<>();
    String[] docs = String.join(" ", lines).split("  ");
    for (String doc : docs)
      documents.add(new Document(doc));

    // -- PART 1

    Integer countValidDocs = Long.valueOf(documents.stream().filter(Document::isValid).count()).intValue();
    System.out.println("There are " + countValidDocs + " valid documents.");

    // -- PART 2

    countValidDocs = Long.valueOf(documents.stream().filter(Document::isConstraintValid).count()).intValue();
    System.out.println("There are " + countValidDocs + " constrained valid documents.");

  }
  
}
