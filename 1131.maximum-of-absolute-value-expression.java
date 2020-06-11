/*
 * @lc app=leetcode id=1131 lang=java
 *
 * [1131] Maximum of Absolute Value Expression
 */

// @lc code=start
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return 0;
        }
        int[][] count = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int ans = Integer.MIN_VALUE;
        for (int cnt = 0; cnt < count.length; ++cnt) {
            int minPrice = Integer.MAX_VALUE;
            for (int i = 0; i < arr1.length; ++i) {
                int cur = arr1[i] * count[cnt][0] + arr2[i] * count[cnt][1] + i;
                int profit = i == 0 ? 0 : cur - minPrice;
                ans = Math.max(ans, profit);
                minPrice = Math.min(minPrice, cur);
            }
        }
        return ans;
    }
}
// @lc code=end

