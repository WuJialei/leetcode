class Solution {
    public boolean increasingTriplet(int[] nums) {
        int s = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        int index = 0;
        while(index < nums.length) {
        	if (nums[index] < s) {
        		s = nums[index];
        	} else if (nums[index] > s && nums[index] < b) {
        		b = nums[index];
        	} else if (nums[index] > b) {
        		return true;
        	}
        	++index;
        }
        return false;
    }
}