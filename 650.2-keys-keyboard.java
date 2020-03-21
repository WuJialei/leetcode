class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            // 最坏情况
            dp[i] = i;
            for (int j = 2; j < i/2; ++j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + 1 + i/j - 1);
                }
            }
        }
        return dp[n];
    }
}