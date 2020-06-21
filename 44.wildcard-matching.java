/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
        // s[i] = p[j] || p[j] = '?', dp[i][j] = dp[i-1][j-1]
        // p[j] = '*', dp[i][j] = dp[i][j-1](j表示空) || dp[i-1][j](j代表有串)
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
            // if (p.charAt(i-1) == '*'){
            //     dp[0][i] = dp[0][i-1];
            // } 
        }
        
        // for (int i = 1; i <= m; ++i) {
        //     int index = i & 1;
        //     for (int j = 1; j <= n; ++j) {
        //         if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
        //             dp[index][j] = dp[1-index][j-1];
        //         } else if (p.charAt(j-1) == '*') {
        //             dp[index][j] = dp[index][j-1] || dp[1-index][j];
        //         } else {
        //             dp[index][j] = false;
        //         }
        //     }
        // }
        // return dp[m&1][n];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } 
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

