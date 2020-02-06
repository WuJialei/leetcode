/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len-1][len-1];
        while (left < right) {
            int mid = left + (right - left)/2;
            int cnt = 0;
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len && matrix[i][j] <= mid; ++j) {
                    ++cnt;
                }
            }
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

