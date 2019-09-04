class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int n = nums.length;
        int iMax = 1;
        int iMin = 1;
        for (int val : nums) {
        	if (val < 0) {
        		int temp = iMax;
        		iMax = iMin;
        		iMin = temp;
        	}
        	iMax = Math.max(val, iMax*val);
        	iMin = Math.min(val, iMin*val);
        	maxValue = Math.max(iMax, maxValue);
        }
        /*
        int[] arrays = new int[n];
        for (int i = 0; i < n; ++i) {
        	for (int j = 0; j < i; ++j) {
        		arrays[j] = arrays[j] * nums[i];
        		maxValue = Math.max(maxValue, arrays[j]);
        	}
        	arrays[i] = nums[i];
        	maxValue = Math.max(maxValue, arrays[i]);
        }
        */
        return maxValue;
    }
}