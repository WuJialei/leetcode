/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {

    public double dfs (double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double ret = dfs(x, n/2);
        return n%2==0 ? ret * ret : ret*ret*x;
    }

    public double myPow(double x, int n) {
        boolean flag = true;
        if (n < 0) {
            flag = false;
            n = -n;
        }
        double ans = dfs(x, n);
        return flag ? ans : 1.0/ans;
    }
}
// @lc code=end

