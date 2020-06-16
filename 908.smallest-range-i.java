/*
 * @lc app=leetcode id=908 lang=java
 *
 * [908] Smallest Range I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] A, int K) {
        if (A == null || A.length < 2) {
            return 0;
        }
        Arrays.sort(A);
        int a = A[0] + K;
        int b = A[A.length-1] - K;
        int ans = 0;
        if (a >= b) {
            return 0;
        } else {
            return b - a;
        }
    }
}
// @lc code=end

