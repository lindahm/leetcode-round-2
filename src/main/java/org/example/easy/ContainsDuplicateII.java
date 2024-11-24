package org.example.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219
 * */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer duplicateNumIndex = numIndices.get(nums[i]);
            if (duplicateNumIndex != null && Math.abs(duplicateNumIndex - i) <= k) {
                return true;
            } else {
                numIndices.put(nums[i], i);
            }
        }
        return false;
    }
}
