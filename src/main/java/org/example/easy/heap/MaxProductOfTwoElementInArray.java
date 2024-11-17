package org.example.easy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1464
 * */
public class MaxProductOfTwoElementInArray {

    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxValues = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            maxValues.add(num);
        }

        return (maxValues.poll() - 1) * (maxValues.poll() - 1);
    }

    public int maxProduct_simpleSolution(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                if (max1 > max2) {
                    max2 = max1;
                }
                max1 = num;
            } else if (max2 > num) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
