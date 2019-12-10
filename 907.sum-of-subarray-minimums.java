/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] A) {
        //思路来源：https://leetcode.flowerplayer.com/2019/04/12/leetcode-907-sum-of-subarray-minimums-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
        int len = A.length;
        int[] leftBigger = new int[len];
        int[] rightBigger = new int[len];
        // 左边相邻连续比A[i]大
        for (int i = 0; i < len; ++i) {
            int cnt = 1;
            int j = i - 1;
            while (j >= 0 && A[j] >= A[i]) {
                cnt += leftBigger[j];
                j -= leftBigger[j];
            }
            leftBigger[i] = cnt;
        }
        // 右边相邻连续比A[i]大
        for (int i = len - 1; i >= 0; --i) {
            int cnt = 1;
            int j = i + 1;
            while (j < len && A[j] > A[i]) {
                cnt += rightBigger[j];
                j += rightBigger[j];
            }
            rightBigger[i] = cnt;
        }
        long sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += (A[i] * leftBigger[i] * rightBigger[i]);
        }
        return (int)(sum % 1_000_000_007);
    }
}
// @lc code=end

