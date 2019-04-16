class Solution {
    public int maxProfit(int[] prices) {
        int cnt = 0;
        if(prices == null || prices.length == 0)
        {
        	return 0;
        }
        for(int i = 1; i < prices.length; ++i)
        {
        	if(prices[i] > prices[i-1])
        	{
        		cnt += prices[i] - prices[i-1];
        	}
        }
        return cnt;
    }
}