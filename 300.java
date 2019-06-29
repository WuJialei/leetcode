class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i){
            int temp = 1;
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    temp = Math.max(temp, dp[j] + 1);
                }                
            }
            //System.out.println("temp: " + temp);
            dp[i] = temp;
        }
        int result = 1;
        for(int t : dp){
            result = Math.max(result, t);
        }
        return result;
    }
}