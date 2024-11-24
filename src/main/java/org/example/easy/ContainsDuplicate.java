package org.example.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 217
 * */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            if (!elements.add(num)) {
                return true;
            }
        }
        return false;
    }
}
