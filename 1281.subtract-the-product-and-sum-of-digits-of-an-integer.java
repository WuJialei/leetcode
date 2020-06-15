/*
 * @lc app=leetcode id=1281 lang=java
 *
 * [1281] Subtract the Product and Sum of Digits of an Integer
 */

// @lc code=start
class Solution {
    public int subtractProductAndSum(int n) {
        int x = 1;
        int y = 0;
        while (n > 0) {
            int cur = n % 10;
            n /= 10;
            x *= cur;
            y += cur;
        }
        return x - y;
    }
}
// @lc code=end

