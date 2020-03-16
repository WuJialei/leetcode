/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 0;
        int ans = 0;
        // dp[i] 表示以 i 结尾的串长度
        for (int i = 2; i < len; ++i) {
            dp[i] = A[i]-A[i-1]==A[i-1]-A[i-2] ? dp[i-1]+1: 0;
            ans += dp[i];
        }
        return ans;
    }
}
// @lc code=end

