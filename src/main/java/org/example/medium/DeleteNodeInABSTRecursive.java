package org.example.medium;

import org.example.TreeNode;

public class DeleteNodeInABSTRecursive {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if ( root.right == null) {
                return root.left;
            }

            TreeNode current = root.right;
            TreeNode min = root.right;

            while (current.left != null) {
                min = current.left;
                current = current.left;
            }

            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }

        return root;
    }
}
