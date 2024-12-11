package org.example.medium;

/**
 * 34
 * */
public class FirstAndLastPosInSortedArray {

    /**
     * The problem with this solution:
     * Given the array: [7, ,7, 8, 8, 8, 8, 8, ..., 8, 7, 7]
     * target = 8;
     *  if we the array is mostly filled with 8, we will end up iterating over
     *  most of the array, so n elements roughly
     *  Because even if we are searching for the low boundary when we encounter an 8
     *  we will be searching both branches when we should be searching only the left one.
     */
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int[] binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return new int[] {-1, -1};
        }
        int mid = (low + high) / 2;

        if (target < nums[mid]) {
            return binarySearch(nums, low, mid - 1, target);

        } else if (target > nums[mid]) {
            return  binarySearch(nums, mid + 1, high, target);

        } else {
            int first = binarySearch(nums, low, mid - 1, target)[0];
            int last = binarySearch(nums, mid + 1, high, target)[1];
            first = first != -1 ? first : mid;
            last = last != -1 ? last : mid;
            return new int[]{first, last};
        }
    }


    public int[] searchRange_optimized(int[] nums, int target) {
        int first = findBoundary(nums, target, true);
        int last = findBoundary(nums, target, false);

        return new int[]{first, last};
    }

    private int findBoundary(int[] nums, int target, boolean searchLowBoundary) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                result = mid;
                if (searchLowBoundary) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return result;
    }

}
