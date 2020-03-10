/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] cur = new int[2];
        int[] bf1 = new int[2];
        int[] bf2 = new int[2];
        bf1[0] = 0;
        bf1[1] = -prices[0];
        bf2[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            cur[0] = Math.max(bf1[1] + prices[i], bf1[0]);
            cur[1] = Math.max(bf2[0] - prices[i], bf1[1]);
            bf2[0] = bf1[0];
            bf2[1] = bf1[1];
            bf1[0] = cur[0];
            bf1[1] = cur[1];
        }
        return cur[0];
    }
}
// @lc code=end

