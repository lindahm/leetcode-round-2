package org.example.twopointers;

/**
 * /!\ WRONG /!\
 *
 * To Revisit Later
 *
 */
public class IndexOfFirstOccurenceInString {

    public int strStr(String haystack, String needle) {
        int n = 0;

        for (int h = 0; h < haystack.length(); h++) {

            if (haystack.charAt(h) == needle.charAt(n)) {
                if (n == needle.length() - 1) {
                    return h - n;
                }
                n++;
            } else {
                n = 0;
            }
        }
        return -1;
    }

}
