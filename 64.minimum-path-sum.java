/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n+1];
        // dp[i][j] = grid[i][j] + min{dp[i-1][j], dp[i][j-1]}
        for (int i = 1; i <= m; ++i) {
            int index = i & 1;
            for (int j = 1; j <= n; ++j) {
                if (i == 1) {
                    dp[index][j] = grid[i-1][j-1] + dp[index][j-1];
                } else if (j == 1) {
                    dp[index][j] = grid[i-1][j-1] + dp[1-index][j];
                } else {
                    dp[index][j] = grid[i-1][j-1] + Math.min(dp[index][j-1], dp[1-index][j]);
                }
                
            }
        }
        return dp[m&1][n];
    }
}
// @lc code=end

