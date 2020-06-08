/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] arrays = new int[32];
        int cnt = 31;
        while (cnt >= 0) {
            arrays[cnt] = n & 1;
            n >>= 1;
            --cnt;
        }
        int left = 0;
        int right = 31;
        while (left < right) {
            int tmp = arrays[left];
            arrays[left] = arrays[right];
            arrays[right] = tmp;
            ++left;
            --right;
        }
        //int flag = arrays[0] == 1 ? -1 : 1;
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            ans = ans * 2 + arrays[i];
        }
        return ans;
    }
}
// @lc code=end

