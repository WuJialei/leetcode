/*
 * @lc app=leetcode id=1140 lang=java
 *
 * [1140] Stone Game II
 */

// @lc code=start
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        int[] sums = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i-1] + piles[i-1];
        }
        // dp[i][j]表示剩余i堆且M为j时的最大数量
        // dp[i][j] = max{(sums[n]-sums[n-i])-dp[i-k][max(k,j)]} k>=1 && k <= 2*j
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= 2*j && k <= i; ++k) {
                    dp[i][j] = Math.max(dp[i][j], sums[n] - sums[n-i] - dp[i-k][Math.min(Math.max(j,k), n)]);
                }
                
            }
        }
        return dp[n][1];
    }
}
// @lc code=end

