/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int a = nums[0];
        int b = 0;
        int ans = a;
        // dp[i]表示以结尾的最大连续子序和
        // dp[i] = max{dp[i-1]+nums[i], nums[i]}
        for (int i = 1; i < nums.length; ++i) {
            b = Math.max(a + nums[i], nums[i]);
            ans = Math.max(b, ans);
            a = b;
        }
        return ans;
    }
}
// @lc code=end

