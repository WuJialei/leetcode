/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// @lc code=start
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[2][n+1];
        // 总值一定，减去的最小和即为公共子串的最大和
        // dp[i][j]表示两个字符串i，j位置时的最大公串和
        for (int i = 1; i <= m; ++i) {
            int index = i & 1;
            for (int j = 1; j <= n; ++j) {
                dp[index][j] = Math.max(dp[index][j-1], dp[1-index][j]);
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[index][j] = Math.max(dp[index][j], dp[1-index][j-1] + (s1.charAt(i-1) - 'a') + 97);
                }
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < m; ++i) {
            sum1 += s1.charAt(i) - 'a' + 97;
        }
        for (int i = 0; i < n; ++i) {
            sum1 += s2.charAt(i) - 'a' + 97;
        }
        return sum1 + sum2 - 2 * dp[m&1][n];

    }
}
// @lc code=end

