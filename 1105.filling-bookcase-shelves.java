/*
 * @lc app=leetcode id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 */

// @lc code=start
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int len = books.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, 1000*1000);
        dp[0] = 0;
        // dp[i] 表示前i本书的最小高度，比较时，从第i本书单独一个书架高度至第i本书最多与前面几本书可以同一个书架，找最小
        for (int i = 1; i <= len; ++i) {
            int j = i - 1;
            int temp_h = 0;
            int temp_w = 0;
            while (j >= 0) {
                temp_w += books[j][0];
                if (temp_w > shelf_width) {
                    break;
                }
                temp_h = Math.max(temp_h, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + temp_h);
                --j;
            }
        }
        return dp[len];
    }
}
// @lc code=end

