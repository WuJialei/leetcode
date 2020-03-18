/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        String str1 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[2][len+1];
        for (int i = 1; i <= len; ++i) {
            int index = i & 1;
            for (int j = 1; j <= len; ++j) {
                dp[index][j] = s.charAt(i-1)==str1.charAt(j-1) ? dp[1-index][j-1] + 1: Math.max(dp[index][j-1], dp[1-index][j]);
            }
        }
        return dp[len&1][len];
    }
}
// @lc code=end

