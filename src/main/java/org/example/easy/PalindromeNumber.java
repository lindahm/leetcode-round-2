package org.example.easy;
/**
 * 9
 * */
public class PalindromeNumber {

    public boolean isPalindrome_stringRepresentation(int x) {
        char[] xChars =  Integer.toString(x).toCharArray();
        int start = 0;
        int end = xChars.length - 1;

        while (start <= end) {
            if (xChars[start] != xChars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    /**
     * Leetcode follow-up question: Could you solve it without converting the integer to a string?
     *
     * */
    public boolean isPalindrome_digitRepresentation(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int number = x;

        while (number > 0) {
            reverse = (reverse * 10) + (number % 10);
            number /= 10;
        }

        return reverse == x;
    }
}
