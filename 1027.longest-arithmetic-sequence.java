/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Sequence
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int[][] dp = new int[A.length][20005];
        int ans = 0;
        // dp[i][len] 表示位置为i的字符和i之前字符值为len的等差数列长度
        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int dis = A[i] - A[j] + 10000;
                // 第一次出现这个distance
                /*
                if (dp[i][dis] == 0) {
                    dp[i][dis] = dp[j][dis] == 0 ? 2: dp[j][dis]+1;
                } else {
                    dp[i][dis] = Math.max(dp[i][dis], dp[j][dis] == 0 ? 2: dp[j][dis]+1);
                }
                */
                dp[i][dis] = Math.max(dp[i][dis], dp[j][dis] == 0 ? 2: dp[j][dis]+1);
                ans = Math.max(ans, dp[i][dis]);
            }
        }
        return ans;
    }
}
// @lc code=end

