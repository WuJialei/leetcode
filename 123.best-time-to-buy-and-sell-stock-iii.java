/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        // 当前卖出能赚的利润(最大利润)
        int[] dp1 = new int[len];
        // 当前买入能赚的利润(最大利润)
        int[] dp2 = new int[len];
        int minPrice = prices[0];
        for (int i = 1; i < len; ++i) {            
            dp1[i] = Math.max(prices[i] - minPrice, dp1[i-1]);
            minPrice = Math.min(minPrice, prices[i]);         
        }
        int maxPrice = prices[len-1];
        for (int i = len-2; i >= 0; --i) {           
            dp2[i] = Math.max(maxPrice - prices[i], dp2[i+1]);
            maxPrice = Math.max(maxPrice, prices[i]);          
        }
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            ans = Math.max(ans, dp1[i] + dp2[i]);
        }
        return ans;
    }
}
// @lc code=end

