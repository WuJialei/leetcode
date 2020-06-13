/*
 * @lc app=leetcode id=372 lang=java
 *
 * [372] Super Pow
 */

// @lc code=start
class Solution {

    public long dfs (long a, int n) {
        a = a % 1337;
        if (n == 0) {
            return 1;
        }
        long ret = dfs(a, n/2) % 1337;
        return n%2==0 ? (ret * ret) % 1337 : (ret * ret * a) % 1337;
    }

    public int superPow(int a, int[] b) {
        long ans = 1;
        for (int bb : b) {
            ans = dfs(ans, 10) * dfs(a, bb) % 1337;
        }
        return (int)(ans % 1337);
    }
}
// @lc code=end

