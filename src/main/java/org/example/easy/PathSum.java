package org.example.easy;
import org.example.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkSum(root, 0, targetSum);
    }

    private boolean checkSum(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        if (isLeaf(root)) {
            return sum == targetSum;
        }

        return checkSum(root.left, sum, targetSum)
                || checkSum(root.right, sum, targetSum);
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
