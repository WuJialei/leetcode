class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int result1 = 0, result2 = 0;
        result1 = dp(nums, 0, n-2);
        result2 = dp(nums, 1, n-1);
        return Math.max(result1, result2);
    }


    public int dp(int[] nums, int start, int end) {
        int pre2 = 0;
        int pre1 = nums[start];
        int cur = pre1;
        for(int i = start+1; i <= end; ++i){
        	cur = Math.max(pre1, pre2 + nums[i]);        	
        	pre2 = pre1;
        	pre1 = cur;
        }        
        return cur;
    }

}