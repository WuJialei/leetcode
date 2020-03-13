/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        if (num >= 1) {
            dp[1] = 1;
            for (int i = 2; i <= num; ++i) {
                dp[i] = dp[i >> 1] + (i&1);
            }
        }
        return dp;
    }
}
// @lc code=end

