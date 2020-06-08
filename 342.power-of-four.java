/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int[] arrays = new int[32];
        int cnt = 0;
        int sum = 0;
        int n = 0;
        while (cnt < 32) {
            arrays[cnt] = num & 1;
            if (arrays[cnt] == 1) {
                ++n;
                if (n > 1 || cnt % 2 == 1) {
                    return false;
                }
            }
            num >>= 1;
            ++cnt;
        }
        return true;
    }
}
// @lc code=end

