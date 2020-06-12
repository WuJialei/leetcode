/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] arrays = new int[32];
        for (int num : nums) {
            int cnt = 31;
            while (cnt >= 0) {
                if ((num & 1) == 1) {
                    ++arrays[cnt];
                }
                num >>= 1;
                --cnt;
            }
        }
        int ans = 0;
        for (int i = 31; i >= 0; --i) {
            if (arrays[i] % 3 == 1) {
                ans |= 1 << (31 - i);
            }
        }
        return ans;
    }
}
// @lc code=end

