class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3){
        	return 0;
        }
        
        int result = 0;
        int n = A.length;
        int[] dp = new int[n];
        for(int i = 2; i < n; ++i){
        	if(A[i] - A[i-1] == A[i-1] - A[i-2]){
        		dp[i] = dp[i-1] + 1;
        	}
        }
        for(int temp : dp){
        	result += temp;
        }
        return result;
    }
}