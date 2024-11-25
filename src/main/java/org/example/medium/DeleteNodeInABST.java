package org.example.medium;


import org.example.TreeNode;

/**
 * 450
 * */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode parent = null;
        TreeNode replacement = null;

        while (current != null) {

            if (key < current.val) {
                current = current.left;
                parent = current;

            } else if (key > current.val) {
                current = current.right;
                parent = current;

            } else {
                replacement = delete(current, parent);
                break;
            }

        }
        return replacement != null ? root : null;

    }

    private TreeNode delete(TreeNode node, TreeNode parent) {
        TreeNode replacement =  null;

        if (node.left != null || node.right != null) {
            replacement = node.left != null ? node.left : node.right;
        } else if (node.left != null && node.right != null) {
            replacement = getMin(node.right);
        }

        if (parent != null) {
            updateParentsChild(node, parent, replacement);
        }  else {
            if (replacement != null) {
                copy(node, replacement);
            } else {
                return null;
            }
        }
        return replacement;
    }

    private static void copy(TreeNode node, TreeNode replacement) {
        node.val = replacement.val;
        node.left = replacement.left;
        node.right = replacement.right;
    }

    private static void updateParentsChild(TreeNode node, TreeNode parent, TreeNode replacement) {
        if (parent.left != null && parent.left.val == node.val) {
            parent.left = replacement;
        } else {
            parent.right = replacement;
        }
    }

    private TreeNode getMin(TreeNode root) {
        TreeNode current = root;
        TreeNode min = root;

        while (current.left != null) {
                min = current.left;
                current = current.left;
        }
        return min;
    }
}
