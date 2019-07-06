class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int n = nums.length;
        int[] subSums = new int[n];
        int oldSums = nums[0];
        //subSums[0] = nums[0];
        //int result = subSums[0];
        int result = oldSums;
        for(int i = 1; i < n; ++i){
        	oldSums = (oldSums>0 ? oldSums : 0) + nums[i];
        	result = Math.max(result, oldSums);
        }
        return result;
    }
}