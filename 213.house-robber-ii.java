/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[2]), nums[1]);
        }
        // 从第1个房子偷到第n-1个房子的最大值
        int a1 = nums[0];
        int b1 = Math.max(nums[1], nums[0]);
        int c1 = b1;
        for (int i = 2; i < nums.length - 1; ++i) {
            c1 = Math.max(nums[i] + a1, b1);
            a1 = b1;
            b1 = c1;
        }
        // 从第2个房子偷到第n个房子的最大值
        int a2 = nums[1];
        int b2 = Math.max(nums[2], nums[1]);
        int c2 = b2;
        for (int i = 3; i < nums.length; ++i) {
            c2 = Math.max(nums[i] + a2, b2);
            a2 = b2;
            b2 = c2;
        }
        return Math.max(c1, c2);
    }
}
// @lc code=end

