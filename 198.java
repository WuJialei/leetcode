class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int n = nums.length;
        int[] profits = new int[n+1];
        profits[0] = 0;
        profits[1] = nums[0];
        for(int i = 2; i <= n; ++i){
        	profits[i] = Math.max(profits[i-1], profits[i-2] + nums[i-1]);
        }
        return profits[n];
    }
}