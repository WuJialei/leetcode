/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] aCnt = new int[6];
        int[] bCnt = new int[6];
        int[] cCnt = new int[6];
        int len = A.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == B[i]) {
                --len;
                ++cCnt[A[i]-1];
            } else {
                ++aCnt[A[i]-1];
                ++bCnt[B[i]-1];
            }
        }
        for (int i = 0; i < aCnt.length; ++i) {
            if ((aCnt[i] + bCnt[i] == len) && (aCnt[i] + bCnt[i] + cCnt[i] == A.length)) {
                ans = Math.min(ans, Math.min(aCnt[i], bCnt[i]));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

