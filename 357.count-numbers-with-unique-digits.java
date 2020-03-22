/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= 10; ++i) {
            int temp = 9;
            for (int cnt = 9; cnt >= 11-i; --cnt) {
                temp *= cnt;
            }
            dp[i] = dp[i-1] + temp;
        }
        if (n <= 10) {
            return dp[n];
        } else {
            return dp[10];
        }
    }
}
// @lc code=end

