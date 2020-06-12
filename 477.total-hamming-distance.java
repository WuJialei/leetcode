/*
 * @lc app=leetcode id=477 lang=java
 *
 * [477] Total Hamming Distance
 */

// @lc code=start
class Solution {

    public int[] bit (int val) {
        int[] ret = new int[32];
        int cnt = 31;
        while (cnt >= 0) {
            ret[cnt] = val & 1;
            val >>= 1;
            --cnt;
        }
        return ret;
    }

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int ans = 0;
        int[][] arrays = new int[nums.length][32];
        for (int i = 0; i < nums.length; ++i) {
            arrays[i] = bit(nums[i]);
        }
        int len = arrays.length;
        for (int i = 0; i < 32; ++i) {
            int cnt1 = 0;
            for (int j = 0; j < len; ++j) {
                if (arrays[j][i] == 1) {
                    ++cnt1;
                }
            }
            ans += (len - cnt1) * cnt1;
        }
        return ans;
    }
}
// @lc code=end

