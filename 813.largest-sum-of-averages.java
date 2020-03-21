/*
 * @lc app=leetcode id=813 lang=java
 *
 * [813] Largest Sum of Averages
 */

// @lc code=start
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[] sums = new double[n+1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = A[i-1] + sums[i-1];
        }
        double[][] dp = new double[2][n+1];
        for (int i = 1; i <= n; ++i) {
            dp[1][i] = sums[i]/i;
        }
        // dp[i,k]表示前i个元素有k个分组的最大均值和，dp[i,k]和dp[k,i]一样
        // dp[i,k] = max{dp[j, k-1] + (nums[j+1]+...nums[i])/(i-j)}
        for (int k = 2; k <= K; ++k) {
            int index = k & 1;
            for (int i = 1; i <= n; ++i) {
                double temp = dp[1-index][i];
                for (int j = 1; j < i; ++j) {
                    temp = Math.max(temp, dp[1-index][j] + (sums[i]-sums[j])/(i-j));
                }
                dp[index][i] = temp;
            }
        }
        return dp[K&1][n];
    }
}
// @lc code=end

