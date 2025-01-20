package org.example.easy;

import org.example.TreeNode;

/**
 * 110
 * */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return areSubTreesBalanced(root) != -1;
    }

    private int areSubTreesBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = areSubTreesBalanced(root.left);
        if (left == -1) {
            return -1;
        }
        int right = areSubTreesBalanced(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

}
