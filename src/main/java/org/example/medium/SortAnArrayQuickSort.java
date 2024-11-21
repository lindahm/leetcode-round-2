package org.example.medium;

public class SortAnArrayQuickSort {

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quicksort(nums, low, pivotIndex - 1);
            quicksort(nums, pivotIndex + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = high;
        int firstGreaterValue = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, firstGreaterValue);
                firstGreaterValue++;
            }
        }
        swap(nums, firstGreaterValue, pivot);
        return firstGreaterValue;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


}
