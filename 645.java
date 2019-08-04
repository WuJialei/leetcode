class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; ++i){
        	while(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
        		swap(nums, i, nums[i]-1);
        	}
        }
        for(int i = 0; i < len; ++i){
        	if(nums[i] != i+1){
        		return new int[]{nums[i], i+1};
        	}
        }
        return null;
    }
    
    public void swap(int[] arrays, int i, int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
    
    
}