/*
 * @lc app=leetcode id=1053 lang=java
 *
 * [1053] Previous Permutation With One Swap
 */

// @lc code=start
class Solution {
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        for (int i = len-1; i > 0; --i) {
            if (A[i-1] > A[i]) {
                for (int j = len-1; j > i-1; --j) {
                    if (A[j] < A[i-1] && A[j] != A[j-1]) {
                        int temp = A[j];
                        A[j] = A[i-1];
                        A[i-1] = temp;
                        return A; 
                    }
                }
            }
        }
        return A;
    }
}
// @lc code=end

