/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int ans = 0;
        int cnt = 32;
        while (cnt > 0) {
            if ((tmp & 1) == 1) {
                ++ans;
            }
            tmp >>= 1;
            --cnt;
        }
        return ans;
    }
}
// @lc code=end

