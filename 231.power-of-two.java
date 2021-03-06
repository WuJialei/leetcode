/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return Integer.bitCount(n) == 1 && n != Integer.MIN_VALUE;
    }
}
// @lc code=end

