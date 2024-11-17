package org.example.twopointers;
/**
 * 392 - with slight optimization for the follow-up question: what is there is a lot of "s" coming in.
 * Hving a local copy as an array is faster than using string.chartAt()
 * */
public class IsSubsequent {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int sIndex = 0;
        int tIndex = 0;

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        while (sIndex < s.length() && tIndex < t.length()) {

            if (sChar[sIndex] == tChar[tIndex]) {
                sIndex++;
            }

            if (sIndex == s.length()) {
                return true;
            }

            tIndex++;
        }

        return false;
    }
}
