/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; ++i) {      
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0 && i-j <= K; --j) {
                max = Math.max(max, A[j]);
                dp[i] = Math.max(dp[i], dp[j] + max * (i-j));
            }
        }
        return dp[len];
    }
}
// @lc code=end

