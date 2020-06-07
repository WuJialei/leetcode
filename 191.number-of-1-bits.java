/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        int cnt = 32;
        while (cnt > 0) {
            if ((n & 1) == 1) {
                ++ans;
            }
            --cnt;
            n >>= 1;
        }
        return ans;
    }
}
// @lc code=end

