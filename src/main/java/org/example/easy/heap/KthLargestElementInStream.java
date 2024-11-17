package org.example.easy.heap;

import java.util.PriorityQueue;

/**
 * 703
 * */
public class KthLargestElementInStream {

    private final int limit;
    private PriorityQueue<Integer> highestScores = new PriorityQueue<>();

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    public KthLargestElementInStream(int k, int[] nums) {
        this.limit = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (highestScores.size() >= limit) {
            if (val > highestScores.peek()) {
                highestScores.poll();
                highestScores.add(val);
            }
        } else {
            highestScores.add(val);
        }
        return !highestScores.isEmpty() ? highestScores.peek() : -1;
    }


}
