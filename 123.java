class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
        	return 0;
        }
        int n = prices.length;
        int[] preProfit = new int[n+1];
        int[] afterProfit = new int[n+1];
        int curMin = prices[0];
        preProfit[1] = 0;
        for(int i = 2; i <= n; ++i){
        	curMin = Math.min(curMin, prices[i-1]);
        	preProfit[i] = Math.max(preProfit[i-1], prices[i-1] - curMin);
        }
        int curMax = prices[n-1];
        afterProfit[n] = 0;
        for(int j = n-1; j > 0; --j){
        	curMax = Math.max(curMax, prices[j-1]);
        	afterProfit[j] = Math.max(afterProfit[j+1], curMax - prices[j-1]);
        }
        int result = 0;
        for(int t = 1; t <= n; ++t){
        	result = Math.max(result, preProfit[t] + afterProfit[t]);
        }
        return result;
    }
}