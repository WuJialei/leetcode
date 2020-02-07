/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n+1];
        int[] postions = new int[primes.length];
        ugly[0] = 1;
        for (int i = 1; i <= n; ++i) {
            int minVal = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < primes.length; ++j) {
                if (minVal > ugly[postions[j]] * primes[j]) {
                    minVal = ugly[postions[j]] * primes[j];
                    index = j;
                } else if (minVal == ugly[postions[j]] * primes[j]) {
                    ++postions[j];
                }
            }
            ugly[i] = minVal;
            ++postions[index];
        }
        return ugly[n-1];
    }
}
// @lc code=end

