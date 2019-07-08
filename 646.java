class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0){
        	return 0;
        }
        int n = pairs.length;
        int[] dp = new int[n+1];
        Arrays.sort(pairs, (a, b)->(a[0]-b[0]));
        Arrays.fill(dp, 1);
        for(int i = 1; i <= n; ++i){
        	for(int j = 1; j < i; ++j){
        		if(pairs[i-1][0] > pairs[j-1][1]){
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}        		
        	}
        }
        int result = dp[0];
        for(int temp : dp){
        	result = Math.max(result, temp);
        }
        return result;
    }
}