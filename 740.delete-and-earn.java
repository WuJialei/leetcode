/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n+1];
        dp[0] = 0;
        int ans = 0;
        dp[1] = nums[0];
        ans = dp[1];
        // dp[i] 是以第i个元素结尾的最大和
        // dp[i] = max{nums[i-1] + dp[j]}, j < i && nums[i-1]-nums[j-1] != 1
        for (int i = 2; i <= n; ++i) {
            for (int j = i-1; j >= 1; --j) {
                while ((j >= 1) && (nums[i-1] - nums[j-1] == 1)) {
                    --j;
                }
                dp[i] = Math.max(dp[i], nums[i-1] + dp[j]);
            }            
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end

