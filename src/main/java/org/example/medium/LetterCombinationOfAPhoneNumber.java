package org.example.medium;

import java.util.*;

/**
 * 17
 * */
public class LetterCombinationOfAPhoneNumber {
    static final Map<Character, char[]> DIGIT_TO_CHAR;

    static {
        DIGIT_TO_CHAR = new HashMap<>();
        DIGIT_TO_CHAR.put('2', new char[]{'a', 'b', 'c'});
        DIGIT_TO_CHAR.put('3', new char[]{'d', 'e', 'f'});
        DIGIT_TO_CHAR.put('4', new char[]{'g', 'h', 'i'});
        DIGIT_TO_CHAR.put('5', new char[]{'j', 'k', 'l'});
        DIGIT_TO_CHAR.put('6', new char[]{'m', 'n', 'o'});
        DIGIT_TO_CHAR.put('7', new char[]{'p', 'q', 'r', 's'});
        DIGIT_TO_CHAR.put('8', new char[]{'t', 'u', 'v'});
        DIGIT_TO_CHAR.put('9', new char[]{'w', 'x', 'y', 'z'});

    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return buildCombinations(digits, new char[digits.length()], -1);
    }

    private List<String> buildCombinations(String digits, char[] combination, int level) {
        List<String> combinations = new ArrayList<>();

        if (level == digits.length() - 1) {
            combinations.add(String.valueOf(combination));
        } else {
            level++;
            for (char letter : DIGIT_TO_CHAR.get(digits.charAt(level))) {
                combination[level] = letter;
                combinations.addAll(buildCombinations(digits, combination, level));
            }
        }
        return combinations;
    }
}
