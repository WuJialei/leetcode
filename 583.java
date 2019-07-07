class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null ){
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
        for(int i = 1; i <= m; ++i){
        	for(int j = 1; j <= n; ++j){
        		dp[i][j] = word1.charAt(i-1)==word2.charAt(j-1) ? dp[i-1][j-1]+1: Math.max(dp[i-1][j], dp[i][j-1]);
        	}
        }
        return m+n - 2*dp[m][n];
    }
}