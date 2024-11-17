package org.example.easy;

/**
 * 14
 * */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
      String reference = strs[0];
        int prefixOffset = 0;
        if (strs.length == 1) {
            return reference;
        }

      for (int i = 0; i < reference.length(); i++) {
          for (int s = 1; s < strs.length; s++) {
              if (i >= strs[s].length() ||  reference.charAt(i) != strs[s].charAt(i)) {
                  return reference.substring(0, prefixOffset);
              }
          }
          prefixOffset++;
      }

      return reference.substring(0, prefixOffset);
    }
}
