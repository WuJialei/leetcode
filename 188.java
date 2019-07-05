class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2 || k < 1){
        	return 0;
        }
        int n = prices.length;
        if(k >= n){
        	return getProfit(prices);
        }
        else{
        	int[][] local = new int[n+1][k+1];
        	int[][] global = new int[n+1][k+1];
        	for(int i = 2; i <= n; ++i){
        		int add = prices[i-1] - prices[i-2];
        		for(int j = 1; j <= k; ++j){
        			local[i][j] = Math.max(add + local[i-1][j], global[i-1][j-1]);
        			global[i][j] = Math.max(local[i][j], global[i-1][j]);
        		}
        	}
        	return global[n][k];
        }
    }

    public int getProfit(int[] nums){
    	int cnt = 0;
    	for(int i = 1; i < nums.length; ++i){
    		if(nums[i] > nums[i-1]){
    			cnt += nums[i]- nums[i-1];
    		}
    	}
    	return cnt;
    }

}