class Solution {
    public int rob(int[] nums) {
        /*
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
        */
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0], b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            ans = Math.max(nums[i] + a, b);
            a = b;
            b =ans;
        }
        return ans;
    }
}
