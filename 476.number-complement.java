/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int i = 1;
        int cur = 0;
        // 找高位第一为1的位数，与全1异或
        while (num > 0) {
            cur = ((num & 1) ^ 1)* i + cur;
            i <<= 1;
            num >>= 1;
        }
        return cur;
    }
}
// @lc code=end

