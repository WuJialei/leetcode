/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[right]) {
            return right + 1;
        }
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

