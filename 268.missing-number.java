/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {

        }
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans ^= i ^ nums[i];
        }
        ans ^= nums.length;
        return ans;
    }
}
// @lc code=end

