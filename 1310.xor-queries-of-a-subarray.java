/*
 * @lc app=leetcode id=1310 lang=java
 *
 * [1310] XOR Queries of a Subarray
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        int[] xors = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            xors[i] = i==0 ? arr[i] : arr[i] ^ xors[i-1];
        }
        int[] ans = new int[queries.length];
        int k = 0;
        for (int[] query : queries) {
            ans[k] = xors[query[0]] ^ xors[query[1]] ^ arr[query[0]];
            ++k;
        }
        return ans;
    }
}
// @lc code=end

