/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n+1];
        for (int i = 1; i <= m; ++i) {
            int index = i & 1;
            for (int j = 1; j <= n; ++j) {
                dp[index][j] = text1.charAt(i-1)==text2.charAt(j-1) ? dp[1-index][j-1] + 1: Math.max(dp[1-index][j], dp[index][j-1]);
            }
        }
        return dp[1&m][n];
    }
}
// @lc code=end

