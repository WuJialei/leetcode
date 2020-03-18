/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n+1];
        dp[0][1] = 1;
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i <= m; ++i) {
            int index = i & 1;
            for (int j = 1; j <= n; ++j) {
                dp[index][j] = dp[index][j-1] + dp[1-index][j];
            }
        }
        return dp[m&1][n];
    }
}
// @lc code=end

