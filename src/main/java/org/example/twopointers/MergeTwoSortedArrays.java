package org.example.twopointers;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[n + m];
        int n1 = 0;
        int n2 = 0;

        for (int r = 0; r < nums1.length; r++) {

            if (n1 < m && (n2 >= n || nums1[n1] <= nums2[n2])) {
                result[r] = nums1[n1];
                n1++;
            } else if (n2 < n && (n1 >= m || nums2[n2] <= nums1[n1])) {
               result[r] = nums2[n2];
               n2++;
            }
        }

        System.arraycopy(result, 0 , nums1, 0, nums1.length);
    }

    public void merge_noExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;

        for (int r = nums1.length - 1; r >= 0; r--) {
            if (n1 >= 0 && (n2 < 0 || nums1[n1] >= nums2[n2])) {
                nums1[r] = nums1[n1];
                n1--;
            } else if (n2 >= 0 && (n1 < 0 || nums2[n2] >= nums1[n1])) {
                nums1[r] = nums2[n2];
                n2--;
            }
        }
    }
}
