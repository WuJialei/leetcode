/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[2][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            dp[0][i] = A[n-1][i];
            ans = Math.min(ans, dp[0][i]);
        }
        if (n == 1) {
            return ans;
        }
        ans = Integer.MAX_VALUE;
        for (int cnt = 1; cnt < n; ++cnt) {
            int index = cnt & 1;
            for (int i = 0; i < n; ++i) {
                int minVal = dp[1-index][i];
                if (i-1 >= 0) {
                    minVal = Math.min(minVal, dp[1-index][i-1]);
                }
                if (i+1 < n) {
                    minVal = Math.min(minVal, dp[1-index][i+1]);
                }
                dp[index][i] = A[n-1-cnt][i] + minVal;
                if (cnt == n-1) {
                    ans = Math.min(ans, dp[index][i]);
                }
            }
            
        }
        return ans;
    }
}
// @lc code=end

