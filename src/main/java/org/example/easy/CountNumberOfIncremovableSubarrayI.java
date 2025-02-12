package org.example.easy;

/**
 * 2970
 * */
public class CountNumberOfIncremovableSubarrayI {

    public int incremovableSubarrayCount(int[] nums) {

        int result = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {

                if (isIncreasingOrder(start, end, nums)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isIncreasingOrder(int startExclusion, int endExclusion, int[] nums) {
        int exclusionRangeSize = endExclusion - startExclusion;
        if ((exclusionRangeSize) == nums.length - 1) {
            return true;
        }
        int previous = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i < startExclusion || i > endExclusion) {
                if (nums[i] <= previous) {
                    return false;
                }
                previous = nums[i];
            }
        }
    return true;
    }
}
