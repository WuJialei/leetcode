class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
        	return 0;
        }
        int n = prices.length;
        int minPrice = prices[0];
        int maxPro = 0;
        for(int i = 1; i < n; ++i){
        	minPrice = Math.min(minPrice, prices[i]);
        	maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        return maxPro;
    }
}

//121. Best Time to Buy and Sell Stock