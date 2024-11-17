package org.example.easy;

/**
 * 26
 * */
public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = slow + 1;

        while (fast < nums.length) {
            while (nums[slow] == nums[fast]) {
                fast++;
                if (fast >= nums.length) {
                    return slow + 1;
                }
            }
            nums[slow + 1] = nums[fast];
        }
        return slow + 1;
    }

    public int removeDuplicates_oneLoop(int[] nums) {
       int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow;
    }
}
