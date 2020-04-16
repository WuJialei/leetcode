/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x/2 + 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            long temp = ((long)mid) * mid;
            if (temp < ((long)x)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        long temp = ((long)left) * left;
        return temp == (long)x ? left : left - 1;
    }
}
// @lc code=end

