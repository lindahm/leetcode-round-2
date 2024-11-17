package org.example.twopointers;

/**
 * 344
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int end = s.length - 1;
        int start = 0;

        while (start <= end) {
            char startValue = s[start];
            s[start] = s[end];
            s[end] = startValue;

            start++;
            end--;
        }
    }
}
