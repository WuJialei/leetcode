/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[2][target+1];
        for (int i = 1; i <= Math.min(target, f); ++i) {
            dp[1][i] = 1;
        }
        // dp[i][j]表示i次摇筛子的和为j
        // dp[i][j] = dp[i-1][j-k], 1 <= k <= j, 第i次摇到的筛子数是k
        for (int i = 2; i <= d; ++i) {
            int index = i & 1;
            for (int j = 1; j <= target; ++j) {
                dp[index][j] = 0;
                for (int k = 1; k <= Math.min(j, f); ++k) {
                    dp[index][j] = (dp[index][j] + dp[1-index][j-k]) % MOD;
                }
            }
        }
        return dp[d&1][target];
    }
}
// @lc code=end

