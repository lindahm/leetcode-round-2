package org.example.easy;

import org.example.TreeNode;

/**
 * 108
 * */
public class ConvertSortedArrayIntoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int low, int high) {
        TreeNode root = null;
        if (low <= high) {
            int mid = (low + high) / 2;
            root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, low, mid - 1);
            root. right = buildBST(nums, mid + 1, high);
        }
        return root;
    }
}
