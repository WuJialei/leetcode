/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num/2 + 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            // z注意整数相乘的溢出
            if (mid < num/mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left == num ? true : false;
    }
}
// @lc code=end

