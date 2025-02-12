package org.example;

public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String reference = strs[0];
        if (strs.length == 1) {
            return reference;
        }

        StringBuilder result = new StringBuilder();
        for (int c = 0; c < reference.length(); c++) {
            for (int i = 1; i < strs.length; i++) {
                if (c >= strs[i].length() || strs[i].charAt(c) != reference.charAt(c)) {
                    return result.toString();
                }
            }
            result.append(reference.charAt(c));
        }
        return result.toString();
    }
}
