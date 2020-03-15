/*
 * @lc app=leetcode id=1227 lang=java
 *
 * [1227] Airplane Seat Assignment Probability
 */

// @lc code=start
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0;
        }
        double sums = 1.0;
        double ans = sums;
        // f(n) = 1/n{f(1) + f(2) + ... + f(n-1)}
        for (int i = 2; i <= n; ++i) {
            ans = (1.0/(double)i) * sums;
            sums += ans;
        }
        return ans;
    }
}
// @lc code=end

