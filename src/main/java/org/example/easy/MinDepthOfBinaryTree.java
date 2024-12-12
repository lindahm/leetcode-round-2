package org.example.easy;

import org.example.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 111
 * */
public class MinDepthOfBinaryTree {

    public int minDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodes = new ArrayDeque<>();
        int minDepth = 0;

        nodes.add(root);
        while (!nodes.isEmpty()) {
            int subTreeCount = nodes.size();
            minDepth++;
            for (int i = 1; i <= subTreeCount; i++) {
                TreeNode current = nodes.poll();
                if (current.left == null && current.right == null) {
                    return minDepth;
                }
                if (current.left != null) nodes.add(current.left);
                if (current.right != null) nodes.add(current.right);
            }
        }

        return minDepth;
    }

    public int minDepth_dfs(TreeNode root) {
        return root == null ? 0 : findMinDepth(root, 1);
    }

    private int findMinDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        if (root.left == null)  {
            return findMinDepth(root.right, depth + 1);
        } else if (root.right == null) {
            return findMinDepth(root.left, depth + 1);
        } else {
            return Math.min(findMinDepth(root.right, depth + 1), findMinDepth(root.left, depth + 1));
        }
    }

}
