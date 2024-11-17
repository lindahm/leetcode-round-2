package org.example.easy;

/**
 * 58
 * */
public class LengthOfTheLastWord {

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int start = end;

        while (start >= 0) {
            if (!Character.isSpaceChar(s.charAt(start))) {
                start--;
            } else {
                if (start != end) {
                    return end - start;
                }
                start--;
                end--;
            }
        }
        return end - start;
    }

}
