package org.example.easy;

import org.example.TreeNode;

/**
 * 543
 * */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return findDiameter(root).diameter;
    }

    private DiameterData findDiameter(TreeNode root) {
        if (root == null) {
            return new DiameterData(0, -1);
        }

        var left = findDiameter(root.left);
        var right = findDiameter(root.right);

        var currentRootDiameter = left.length + right.length + 2;
        var maxDiameter = Math.max(Math.max(left.diameter, right.diameter), currentRootDiameter);

        return new DiameterData(maxDiameter, 1 + Math.max(left.length, right.length));
    }

    private static class DiameterData {
        final int diameter;
        final int length;

        public DiameterData(int diameter, int length) {
            this.diameter = diameter;
            this.length = length;
        }
    }

    /**
     * Testing if faster on leetcode with local variable: YES.
     * Previous version processes diameter more than it has to.
     */
    int diameter;
    public int diameterOfBinaryTree_usingLocal(TreeNode root) {
        findDiameter_v2(root);
        return diameter;
    }

    private int findDiameter_v2(TreeNode root) {
        if (root == null) {
            return -1;
        }

        var left = findDiameter_v2(root.left);
        var right = findDiameter_v2(root.right);

        var currentRootDiameter = left + right + 2;
        diameter = Math.max(diameter, currentRootDiameter);

        return 1 + Math.max(left, right);
    }
}
