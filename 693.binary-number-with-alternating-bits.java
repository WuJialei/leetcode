/*
 * @lc app=leetcode id=693 lang=java
 *
 * [693] Binary Number with Alternating Bits
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n < 1) {
            return false;
        }
        int pre = n & 1;
        n >>= 1;
        while (n > 0) {
            int cur = n & 1;
            n >>= 1;
            if ((pre ^ cur) != 1) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
// @lc code=end

