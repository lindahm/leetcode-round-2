package org.example.easy;

import org.example.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 104
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        } else {
            return 0;
        }
    }

    public int maxDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        int maxDepth = 0;
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            maxDepth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = nodes.poll();
                if (current.left != null) nodes.add(current.left);
                if (current.right != null) nodes.add(current.right);
            }
        }

        return maxDepth;
    }

    public int maxDepth_dfs_iterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<NodeDepth> nodes = new ArrayDeque<>();
        nodes.add(new NodeDepth(root, 1));
        int maxDepth = 1;

        while (!nodes.isEmpty()) {
            NodeDepth current = nodes.pollLast();
            maxDepth = Math.max(current.depth(), maxDepth);

            if (current.node().right != null) nodes.add(new NodeDepth(current.node().right, current.depth() + 1));
            if (current.node().left != null) nodes.add(new NodeDepth(current.node().left, current.depth() + 1));
        }

        return maxDepth;
    }

    private static class NodeDepth {
        private TreeNode node;
        private int depth;

        public NodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        public TreeNode node() {
            return node;
        }

        public int depth() {
            return depth;
        }
    }

}
