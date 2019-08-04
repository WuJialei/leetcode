class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int len = nums.length;
        for(int i = 0; i < nums.length; ++i){
        	if(nums[i] != 0){
        		nums[index++] = nums[i];
        	}
        }
        while(index < len){
        	nums[index++] = 0;
        }
    }
}