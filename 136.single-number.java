/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums[0];
        }
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
// @lc code=end

