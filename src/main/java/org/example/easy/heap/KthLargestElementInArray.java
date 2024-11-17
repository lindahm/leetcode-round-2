package org.example.easy.heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kLargestElements = new PriorityQueue<>();

        for (int num : nums) {
            kLargestElements.add(num);
            if (kLargestElements.size() > k) {
                kLargestElements.poll();
            }
        }

        return kLargestElements.poll();
    }
}
