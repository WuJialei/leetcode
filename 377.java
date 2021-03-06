class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target == 0){
        	return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; ++i){
        	for(int temp : nums){
        		if(i >= temp){
        			dp[i] += dp[i - temp];
        		}
        	}
        }
        return dp[target];
    }
}