package org.example.medium;

import org.example.TreeNode;

/**
 * 98
 * */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root != null) {
            boolean isValidNode = root.val < max && root.val > min;

            return isValidNode
                    && isValid(root.left, min, root.val)
                    && isValid(root.right, root.val, max);
        }

        return true;
    }
}
