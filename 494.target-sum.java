/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {

    private int[] arrays;
    private int ans;
    private int len;
    
    public void dfs (int index, int target) {
        if (index == len) {
            if (target == 0) {
                ++ans;
            }
            return;
        }
        // if (target < -(len - index) || target > (len - index)) {
        //     return;
        // }
        dfs(index+1, target - arrays[index]);
        dfs(index+1, target + arrays[index]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        arrays = nums;
        len = nums.length;
        ans = 0;
        dfs(0, S);
        return ans;
    }
}
// @lc code=end

