class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
        	return 0;
        }
        if(word1.length() == 0){
        	return word2.length();
        }
        if(word2.length() == 0){
        	return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= n; ++i){
        	dp[0][i] = i;
        }
        for(int j = 0; j <= m; ++j){
        	dp[j][0] = j;
        }
        for(int i = 1; i <= m; ++i){
        	for(int j = 1; j <= n; ++j){
        		if(word1.charAt(i-1) == word2.charAt(j-1)){
        			dp[i][j] = dp[i-1][j-1];
        		}
        		else{
        			int insert = dp[i][j-1];
        			int delete = dp[i-1][j];
        			int replace = dp[i-1][j-1];
        			dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        		}
        	}
        }
        return dp[m][n];
    }
}