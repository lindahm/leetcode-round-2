package org.example.twopointers;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int offset = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                offset++;
            } else {
                nums[i - offset] = nums[i];
            }
        }

        for (int i = nums.length - offset; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes_twoPointers(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int leftValue = nums[left];
                nums[left] = nums[right];
                nums[right] = leftValue;
                left++;
            }
        }
    }
}