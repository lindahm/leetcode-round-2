package org.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        return buildSubsets(nums, 0, new ArrayList<>());
    }

    private List<List<Integer>> buildSubsets(int[] nums, int index, List<Integer> currentSubset) {
        List<List<Integer>> results = new ArrayList<>();
        if (index == nums.length) {
            results.add(List.copyOf(currentSubset));
            return results;
        }

        currentSubset.add(nums[index]);
        results.addAll(buildSubsets(nums, index + 1, currentSubset));

        currentSubset.removeLast();
        results.addAll(buildSubsets(nums, index + 1, currentSubset));

        return results;
    }
}
