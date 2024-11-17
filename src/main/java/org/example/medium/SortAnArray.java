package org.example.medium;

import java.util.Arrays;

/**
 * 912
 */
public class SortAnArray {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    private void merge(int[] array, int low, int middle, int high) {
        int[] left = Arrays.copyOfRange(array, low, middle + 1);
        int[] right = Arrays.copyOfRange(array, middle + 1, high + 1);
        int l = 0;
        int r = 0;

        for (int i = low; i <= high; i++) {
            if (l < left.length && (r >= right.length || left[l] <= right[r])) {
                array[i] = left[l];
                l++;
            } else if (r < right.length && (l >= left.length || right[r] <= left[l])) {
                array[i] = right[r];
                r++;
            }
        }
    }

    private void merge_v2(int[] array, int low, int middle, int high) {
        int[] left = Arrays.copyOfRange(array, low, middle + 1);
        int[] right = Arrays.copyOfRange(array, middle + 1, high + 1);
        int l = 0;
        int r = 0;
        int a = low;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                array[a] = left[l];
                l++;
            } else {
                array[a] = right[r];
                r++;
            }
            a++;
        }
        while (l < left.length) {
            array[a] = left[l];
            l++;
            a++;
        }
        while (r < right.length) {
            array[a] = right[r];
            r++;
            a++;
        }
    }


}

