/*
 * @lc app=leetcode id=1025 lang=java
 *
 * [1025] Divisor Game
 */

// @lc code=start
class Solution {
    public boolean divisorGame(int N) {
        // 最优的数不是最大的约数，而是能找到的让自己立于不败之地的最合适的数
        if (N <= 1) {
            return false;
        }
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                if (i%j==0 && !dp[i-j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

}
// @lc code=end

