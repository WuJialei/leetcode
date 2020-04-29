/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            int index = (int)Math.sqrt(i);
            if (index * index == i) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= index; ++j) {
                    min = Math.min(min, 1 + dp[i - j*j]);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
// @lc code=end

