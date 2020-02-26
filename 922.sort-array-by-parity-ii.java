/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
        /*
        int[] odds = new int[A.length/2];
        int[] evens = new int[A.length/2];
        int o = 0, e = 0;
        for (int a : A) {
            if ((a%2) == 0) {
                evens[e++] = a;
            } else {
                odds[o++] = a;
            }
        }
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length/2; i++) {
            ans[i*2] = evens[i];
            ans[i*2+1] = odds[i];
        }
        return ans;
        */
    }
}
// @lc code=end

