/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, target, 0, matrix[0].length - 1);
    }

    public boolean search (int[][] matrix, int target, int row, int col) {
        if (row >= matrix.length || col < 0) {
            return false;
        }
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] > target) {
            return search(matrix, target, row, col-1);
        } else {
            return search(matrix, target, row+1, col);
        }
    }

}
// @lc code=end

