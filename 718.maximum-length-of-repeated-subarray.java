/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[2][n+1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            int index = i & 1;
            for (int j = 1; j <= n; ++j) {
                dp[index][j] = A[i-1]==B[j-1] ? dp[1-index][j-1] + 1: 0;
                ans = Math.max(ans, dp[index][j]);
            }

        }
        return ans;
    }
}
// @lc code=end

