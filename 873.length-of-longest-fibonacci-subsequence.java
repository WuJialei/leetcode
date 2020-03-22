import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=873 lang=java
 *
 * [873] Length of Longest Fibonacci Subsequence
 */

// @lc code=start
class Solution {

    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            index.put(A[i], i);
        }
        int ans = 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int k = 0; k < n; ++k) {
            for (int j = k-1; j > 0; --j) {
                int i = index.getOrDefault(A[k]-A[j], -1);
                if (i >= 0 && i < j) {
                    int temp = dp.getOrDefault(i*n + j, 2) + 1;
                    dp.put(j*n + k, temp);
                    ans = Math.max(ans, temp);
                }
            }
        }
        if (ans < 3) {
            return 0;
        } else {
            return ans;
        }
    }
}
// @lc code=end

