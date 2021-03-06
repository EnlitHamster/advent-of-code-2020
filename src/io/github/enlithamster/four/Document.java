package io.github.enlithamster.four;

import java.util.HashMap;

public class Document {
  
  public static enum Field {byr, iyr, eyr, hgt, hcl, ecl, pid, cid};

  private HashMap<Field, String> fields;

  public Document(String doc) {
    fields = new HashMap<>();
    String[] entries = doc.split(" ");
    for (String entry : entries) {
      String[] fieldEntry = entry.split(":");
      fields.put(Field.valueOf(fieldEntry[0]), fieldEntry[1]);
    }
  }

  public Boolean isValid() {
    return fields.containsKey(Field.byr) 
        && fields.containsKey(Field.iyr)
        && fields.containsKey(Field.eyr)
        && fields.containsKey(Field.hgt)
        && fields.containsKey(Field.hcl)
        && fields.containsKey(Field.ecl)
        && fields.containsKey(Field.pid);
  }

  public Boolean isConstraintValid() {
    if ( !fields.containsKey(Field.byr) 
      || !fields.containsKey(Field.iyr)
      || !fields.containsKey(Field.eyr)
      || !fields.containsKey(Field.hgt)
      || !fields.containsKey(Field.hcl)
      || !fields.containsKey(Field.ecl)
      || !fields.containsKey(Field.pid) 
      || fields.get(Field.byr).length() != 4  
      || fields.get(Field.iyr).length() != 4  
      || fields.get(Field.eyr).length() != 4 ) return Boolean.FALSE;

    try {
      Integer byr = Integer.parseInt(fields.get(Field.byr));
      Integer iyr = Integer.parseInt(fields.get(Field.iyr));
      Integer eyr = Integer.parseInt(fields.get(Field.eyr));

      Boolean checkBYR = byr.compareTo(1920) >= 0 && byr.compareTo(2002) <= 0;
      Boolean checkIYR = iyr.compareTo(2010) >= 0 && iyr.compareTo(2020) <= 0;
      Boolean checkEYR = eyr.compareTo(2020) >= 0 && eyr.compareTo(2030) <= 0;
      Boolean checkHGT = checkHeight();
      Boolean checkHCL = checkHairColor();
      Boolean checkECL = checkEyeColor();
      Boolean checkPID = checkPID();

      return checkBYR && checkIYR && checkEYR && checkHGT && checkHCL && checkECL && checkPID;
    } catch (Exception e) {
      return Boolean.FALSE;
    }
  }

  public Boolean checkHeight() {
    String hgt = fields.get(Field.hgt);
    Boolean isCm = hgt.endsWith("cm");
    Boolean isIn = hgt.endsWith("in");

    if (isCm || isIn) {
        try {
          Integer height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
          if (isCm) return height.compareTo(150) >= 0 && height.compareTo(193) <= 0;
          if (isIn) return height.compareTo(59) >= 0 && height.compareTo(76) <= 0;
        } catch (Exception e) {
          return Boolean.FALSE;
        }
    }

    return Boolean.FALSE;
  }

  public Boolean checkHairColor() {
    String hcl = fields.get(Field.hcl);
    if (hcl.length() == 7 && hcl.startsWith("#")) {
      String hex = hcl.substring(1);
      for (Character c : hex.toCharArray()) {
        if (!(Character.isDigit(c) || (c.compareTo('a') >= 0 && c.compareTo('f') <= 0)))
          return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  public Boolean checkEyeColor() {
    String ecl = fields.get(Field.ecl);
    return ecl.equals("amb")
        || ecl.equals("blu")
        || ecl.equals("brn")
        || ecl.equals("gry")
        || ecl.equals("grn")
        || ecl.equals("hzl")
        || ecl.equals("oth");
  }

  public Boolean checkPID() {
    String pid = fields.get(Field.pid);
    try {
      if (pid.length() != 9)
        return Boolean.FALSE;
      Integer.parseInt(pid);
    } catch (Exception e) {
      return Boolean.FALSE;
    }

    return Boolean.TRUE;
  }

}
