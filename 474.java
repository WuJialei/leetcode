class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0){
        	return 0;
        }
        int cnt = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(int t = 0; t < cnt; ++t){
        	String strTemp = strs[t];
        	int zeros = 0, ones = 0;
        	for(char c : strTemp.toCharArray()){
        		if(c == '0'){
        			++zeros;
        		}
        		else if(c == '1'){
        			++ones;
        		}
        	}
        	for(int i = m; i >= 0; --i){
        		for(int j = n; j >= 0; --j){
        			if(i >= zeros && j >= ones){
        				dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        			}
        		}
        	}
        }
        return dp[m][n];
    }
}