/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Integer nums1[] = new Integer[nums.length];
        for (int i = 0 ; i < nums.length ; i ++) nums1[i] = nums[i];
        // Arrays.sort()支持Integer [] 而不支持 int []
        Arrays.sort(nums1, (a, b) -> b-a);
        return nums1[k-1];
    }
}
// @lc code=end

