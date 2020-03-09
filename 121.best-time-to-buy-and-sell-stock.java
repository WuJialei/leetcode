/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int tempProfit = prices[i] - minPrice > 0 ? prices[i] - minPrice : 0;
            maxProfit = Math.max(maxProfit, tempProfit);
            minPrice = Math.min(minPrice, prices[i]);

        }
        return maxProfit;
    }
}
// @lc code=end

