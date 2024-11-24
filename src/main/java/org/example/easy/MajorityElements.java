package org.example.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 169
 * */
public class MajorityElements {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numCounter = new HashMap<>();
        int majority = nums.length / 2;

        for (int num : nums) {
            int count = numCounter.merge(num, 1, Integer::sum);
            if (count > majority) {
                return num;
            }
        }

        return -1;

    }


}
