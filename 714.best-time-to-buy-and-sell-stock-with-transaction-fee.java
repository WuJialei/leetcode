/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] bf1 = new int[2];
        int[] cur = new int[2];
        bf1[0] = 0;
        bf1[1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; ++i) {
            cur[0] = Math.max(bf1[0], bf1[1] + prices[i]);
            cur[1] = Math.max(bf1[1], bf1[0] - prices[i] - fee);
            bf1[0] = cur[0];
            bf1[1] = cur[1];
        }
        return cur[0];
    }
}
// @lc code=end

