package org.example.medium;


import org.example.TreeNode;

/**
 * 450
 * */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode parent = null;
        TreeNode updatedNode = null;
        boolean shouldUpdateRoot = false;

        while (current != null) {

            if (key < current.val) {
                parent = current;
                current = current.left;

            } else if (key > current.val) {
                parent = current;
                current = current.right;

            } else {
                updatedNode = delete(current, parent);
                shouldUpdateRoot = parent == null;
                break;
            }
        }
        return shouldUpdateRoot ? updatedNode : root;

    }

    private TreeNode delete(TreeNode node, TreeNode parent) {
        if (node.left != null && node.right != null) {
            return replaceWithMinFromSubTree(node);
        } else {
            return updateParentsChild(node, parent, node.left != null ? node.left : node.right);
        }
    }

    private static TreeNode updateParentsChild(TreeNode node, TreeNode parent, TreeNode replacement) {
        if (parent == null) {
            return replacement;
        } else if (parent.left != null && parent.left.val == node.val) {
            parent.left = replacement;
        } else {
            parent.right = replacement;
        }
        return null;
    }

    private static TreeNode replaceWithMinFromSubTree(TreeNode node) {
        TreeNode current = node.right;
        TreeNode min = node.right;
        TreeNode parent = node;

        while (current.left != null) {
            parent = current;
            min = current.left;
            current = current.left;
        }

        node.val = min.val;
        updateParentsChild(min, parent, min.right);
        return node;
    }

}
