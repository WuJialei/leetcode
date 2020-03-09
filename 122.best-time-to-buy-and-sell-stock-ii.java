/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profits = 0;
        for (int i = 1; i < prices.length; ++i) {
            int temp = prices[i] - prices[i-1];
            if (temp > 0) {
                profits += temp;
            }
        }
        return profits;
    }
}
// @lc code=end

