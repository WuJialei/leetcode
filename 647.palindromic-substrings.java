/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int end = 0; end < n; ++end) {
            for (int start = end; start >= 0; --start) {
                if (start == end) {
                    dp[start][end] = true;
                    ++ans;
                } else if (end - start == 1) {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = true;
                        ++ans;
                    }
                } else if (end - start >= 2) {
                    if (s.charAt(start) == s.charAt(end) && dp[start+1][end-1]) {
                        dp[start][end] = true;
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

