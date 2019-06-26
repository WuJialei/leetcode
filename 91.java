class Solution {
    public int numDecodings(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int index = 2; index <= n; ++index){
        	int indexValue = Integer.valueOf(s.substring(index-1, index));
        	if(indexValue != 0){
        		dp[index] = dp[index-1];
        	}
        	if(s.charAt(index-2) == '0'){
        		continue;
        	}
        	int preValue = Integer.valueOf(s.substring(index-2, index));
        	if(preValue <= 26){
        		dp[index] += dp[index-2];
        	}
        }
        return dp[n];
    }
}