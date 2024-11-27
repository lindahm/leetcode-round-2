package org.example.easy;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 501
 * */
public class FindModeInBST {

    private static class Count {
        int val;
        int count;

        public Count(Integer val) {
            this.val = val;
            count = 1;
        }

        public int count() {
            return count;
        }
    }

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> modes = new ArrayList<>();
        inOrderTraversal(modes, root, 0, 0);
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderTraversal(List<Integer> modes, TreeNode root, int maxCount, int currentCount) {

        if (root != null) {
            inOrderTraversal(modes, root.left, maxCount, currentCount);

            if (modes.isEmpty()) {
                modes.add(root.val);
                currentCount++;
            } else {
                int previousVal = modes.getLast();

                if (previousVal == root.val) {
                    currentCount++;

                } else {
                    if (currentCount >= maxCount) {
                        maxCount = currentCount;
                    } else {
                        modes.removeLast();
                    }
                    modes.add(root.val);
                    currentCount = 0;
                }
            }
            inOrderTraversal(modes, root.right, maxCount, currentCount);
        }
    }
}
