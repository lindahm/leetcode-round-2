package org.example.easy;

import java.util.Map;
/**
 * 13
 * */
public class RomanToInteger {

    public int romanToInt(String s) {
        final Map<Character, Integer> romanToInt= Map.of(
        'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int previousRomanValue = 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentRomanValue = romanToInt.get(s.charAt(i));
            result += currentRomanValue < previousRomanValue ? - currentRomanValue : currentRomanValue;

            previousRomanValue = currentRomanValue;
        }

        return result;
    }
}
