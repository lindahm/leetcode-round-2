package org.example.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 20
 * */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );
        Deque<Character> openParentheses = new ArrayDeque<>();

        for (char parenthesis : s.toCharArray()) {
            if (pairs.containsKey(parenthesis)) {
                openParentheses.push(parenthesis);
            } else if (openParentheses.isEmpty() || !pairs.get(openParentheses.pop()).equals(parenthesis)) {
                return false;
            }
        }
        return openParentheses.isEmpty();
    }

}
