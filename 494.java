class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int n = nums.length;
        int sum = 0;
        for(int tmp : nums){
        	sum += tmp;
        }
        if(sum < S || (sum+S)%2 != 0){
        	return 0;
        }
        int cnt = (sum + S)/2;
        int[] dp = new int[cnt+1];
        dp[0] = 1;
        for(int i = 0; i < n; ++i){
        	for(int j = cnt; j >= nums[i]; --j){
        		dp[j] += dp[j - nums[i]];
        	}
        }
        return dp[cnt];
    }
}