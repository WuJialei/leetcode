import java.util.TreeSet;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length ==0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] - t <= floor) {
                return true;
            }
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && ceil <= nums[i] + t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
// @lc code=end

