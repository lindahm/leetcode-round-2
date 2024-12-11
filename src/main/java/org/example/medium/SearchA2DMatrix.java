package org.example.medium;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        final int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }
        return findTargetinRow(matrix, target, row);
    }

    private static boolean findTargetinRow(int[][] matrix, int target, int row) {
        int low = 0;
        int high = matrix[row].length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < matrix[row][mid]) {
                high = mid - 1;
            } else if (target > matrix[row][mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private static int findRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int rowLastItemIndex = matrix[mid].length - 1;

            if (target < matrix[mid][0]) {
                    high = mid - 1;
            } else if (target > matrix[mid][rowLastItemIndex]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
