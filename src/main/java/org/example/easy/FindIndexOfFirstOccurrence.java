package org.example.easy;

/**
 * 28
 * */
public class FindIndexOfFirstOccurrence {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int h = 0; h < haystack.length() - needle.length() + 1; h++) {

            for (int n = 0; n < needle.length(); n++) {
                if (haystack.charAt(h + n) != needle.charAt(n)) {
                    break;
                } else if (n == needle.length() - 1) {
                    return h;
                }
            }
        }
        return -1;
    }
}
