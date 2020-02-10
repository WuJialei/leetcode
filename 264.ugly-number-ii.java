/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int[] primes = {2, 3, 5};
        int[] pos = new int[primes.length];
        for (int i = 1; i < n; ++i) {
            int minVal = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < primes.length; ++j) {
                if (minVal > ans[pos[j]] * primes[j]) {
                    minVal = ans[pos[j]] * primes[j];
                    index = j;
                } else if (minVal == ans[pos[j]] * primes[j]) {
                    ++pos[j];
                }                
            }
            ++pos[index];
            ans[i] = minVal;
        }
        return ans[n-1];
    }
}
// @lc code=end

