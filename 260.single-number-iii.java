/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        int ab = 0;
        for (int num : nums) {
            ab ^= num;
        }
        int cnt = 1;
        while (ab != 0) {
            if ((ab & 1) == 1) {
                break;
            }
            ab >>= 1;
            cnt <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & cnt) == cnt) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        int[] ans = new int[]{a, b};
        return ans;
    }
}
// @lc code=end

