class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
        	return false;
        }
        int cnt = 0;
        for(int temp : nums){
        	cnt += temp;
        }
        if(cnt % 2 != 0){
        	return false;
        }
        else{
        	cnt /= 2;
        }
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][cnt+1];
        for(int t = 0; t <= cnt; ++t){
        	if(t == nums[0]){
        		dp[1][t] = true;
        	}
        }
        for(int i = 2; i <= n; ++i){
        	for(int j = 1; j <= cnt; ++j){
        		if(j >= nums[i-1]){
        			dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
        		}
        		else{
        			dp[i][j] = dp[i-1][j];
        		}
        		
        	}
        }
        return dp[n][cnt];
    }
}