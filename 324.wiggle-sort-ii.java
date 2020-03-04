import java.util.Arrays;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int len = nums.length%2 == 0 ? nums.length/2: nums.length/2 + 1;
        int[] odd = Arrays.copyOfRange(nums, 0, len);
        int[] even = Arrays.copyOfRange(nums, len, nums.length);
        int cnt = odd.length-1;
        int i = 0;
        while (cnt >= 0) {
            nums[i] = odd[cnt--];
            i += 2;
        }
        cnt = even.length-1;
        i = 1;
        while (cnt >= 0) {
            nums[i] = even[cnt--];
            i += 2;
        }
    }
}
// @lc code=end

