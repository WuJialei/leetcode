/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        // if (n == 1) {
        //     return 1;
        // }
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left)/2;
            // 乘法溢出问题
            long temp = ((long)mid) * (mid+1)/2;
            if (temp < (long)n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // return left-1;
        long temp = ((long)left)*(left+1)/2;
        return temp == (long)n ? left : left - 1;
    }
}
// @lc code=end

