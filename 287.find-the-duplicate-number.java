/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int left  = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    ++cnt;
                }                
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

