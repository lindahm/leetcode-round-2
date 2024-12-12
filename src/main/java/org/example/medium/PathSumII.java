package org.example.medium;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113
 * */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return gatherPaths(root, new ArrayList<>(), 0, targetSum);
    }

    private List<List<Integer>> gatherPaths(TreeNode root, List<Integer> path, int sum, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            sum += root.val;
            path.add(root.val);

            if (isLeaf(root)) {
                if (sum == targetSum) {
                    result.add(List.copyOf(path));
                }
            } else {
                List<List<Integer>> left = gatherPaths(root.left, path, sum, targetSum);
                List<List<Integer>> right = gatherPaths(root.right, path, sum, targetSum);

                if (!left.isEmpty()) result.addAll(left);
                if (!right.isEmpty()) result.addAll(right);

            }
            path.removeLast();
        }

        return result;
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
