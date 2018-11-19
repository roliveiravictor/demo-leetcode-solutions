package com.leetcode.numUniqueEmails;

/*
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 */

import com.leetcode.interfaces.MineSolution;

import java.util.HashSet;
import java.util.Set;

@MineSolution
public class Solution {

    private final int NAME_INDEX = 0;
    private final int DOMAIN_INDEX = 1;

    public int numUniqueEmails(String[] emails) {
        final Set<String> seen = new HashSet();
        for (String email: emails) {
            final String[] splittedMail = email.split("@");

            String name = splittedMail[NAME_INDEX];
            if (name.contains("+")) {
                name = name.substring(0, name.indexOf('+'));
            }

            name = name.replaceAll(".", "");

            final String domain = splittedMail[DOMAIN_INDEX];

            seen.add(name + domain);
        }

        return seen.size();
    }
}

@TopLeetCodeSolution
public int numUniqueEmails(String[] emails) {
      if (emails == null || emails.length == 0) {
        return 0;
      }

      Set<String> set = new HashSet<>();
      for (String email : emails) {
        StringBuilder sb = new StringBuilder();
        boolean isBeforePlus = true;
        int idxOfAt = 0;
        for (int i = 0; i < email.length(); i++) {
          if (isBeforePlus && email.charAt(i) != '@') {
            if (email.charAt(i) == '.') {
              continue;
            } else if (email.charAt(i) == '+') {
              isBeforePlus = false;
            } else {
              sb.append(email.charAt(i));
            }
          } else if (email.charAt(i) == '@') {
            idxOfAt = i;
            break;
          }
        }
        sb.append(email.substring(idxOfAt));
        set.add(sb.toString());
      }

      return set.size();
}
