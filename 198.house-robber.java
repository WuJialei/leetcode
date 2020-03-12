/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        /*
        int bf0 = 0;
        int bf1 = nums[0];
        int cur0 = bf0;
        int cur1 = bf1;
        // dp[i][0] = max{dp[i-1][0], dp[i-1][1]}
        // dp[i][1] = dp[i-1][0] + nums[i]
        for (int i = 1; i < nums.length; ++i) {
            cur0 = Math.max(bf0, bf1);
            cur1 = bf0 + nums[i];
            bf0 = cur0;
            bf1 = cur1;
        }
        return Math.max(cur0, cur1);
        */
        if (nums.length == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c = b;
        for (int i = 2; i < nums.length; ++i) {
            c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}
// @lc code=end

