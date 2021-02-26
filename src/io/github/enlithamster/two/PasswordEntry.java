package io.github.enlithamster.two;

public class PasswordEntry {

  public final Integer lowerBound;
  public final Integer upperBound;
  public final Character requiredChar;
  public final String password;

  public PasswordEntry(String entry) {
    String[] policyPassword = entry.split(": ");
    String[] boundRequired = policyPassword[0].split(" ");
    String[] bounds = boundRequired[0].split("-");

    lowerBound = Integer.parseInt(bounds[0]);
    upperBound = Integer.parseInt(bounds[1]);
    requiredChar = boundRequired[1].charAt(0);
    password = policyPassword[1];
  }

  public boolean isBoundCompliant() {
    Integer charCount = Long.valueOf(password.chars().filter(c -> c == requiredChar).count()).intValue();
    return charCount >= lowerBound && charCount <= upperBound;
  }

  public boolean isPositionCompliant() {
    // Indeces are in mathematical fashion, thus index - 1 for the array access
    Boolean position1 = requiredChar.equals(password.charAt(lowerBound - 1));
    Boolean position2 = requiredChar.equals(password.charAt(upperBound - 1));
    return Boolean.logicalXor(position1, position2);
  }

}
