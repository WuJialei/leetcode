/*
 * @lc app=leetcode id=1342 lang=java
 *
 * [1342] Number of Steps to Reduce a Number to Zero
 */

// @lc code=start
class Solution {
    public int numberOfSteps (int num) {
        int ans = 0;
        while (true) {
            if (num == 0) {
                return ans;
            }
            if ((num & 1) == 1) {
                num -= 1;
            } else {
                num >>= 1;
            }
            ++ans;
        }
    }
}
// @lc code=end

