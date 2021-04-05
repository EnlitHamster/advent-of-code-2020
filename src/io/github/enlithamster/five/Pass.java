package io.github.enlithamster.five;

public class Pass {

  public final static Integer MAX_ID = 8 * 127 + 7;

  // F = 0; B = 1
  // L = 0; R = 1
  // ID = 8 * ROW + COL

  private Integer row;
  private Integer col;

  public Pass(String id) {
    String rowId = id.substring(0, 7);
    String colId = id.substring(7, 10);

    row = 0;
    col = 0;

    // += 2 ^ (6 - i)
    for (Integer i = 0; i < 7; ++i)
      if (rowId.charAt(i) == 'B')
        row += (int) Math.pow(2, 6-i);

    // += 2 ^ (2 - i)
    for (Integer i = 0; i < 3; ++i)
      if (colId.charAt(i) == 'R')
        col += (int) Math.pow(2, 2-i);
  }

  public Integer UID() {
    return 8 * row + col;
  }
  
}
