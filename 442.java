class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
        	while(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
        		swap(nums, i, nums[i]-1);
        	}
        }
        for (int j = 0; j < len; ++j) {
        	if(nums[j] != j+1){
        		result.add(nums[j]);
        	}
        }
        return result;
    }

    public void swap(int[] arrays, int a, int b){
    	int temp = arrays[a];
    	arrays[a] = arrays[b];
    	arrays[b] = temp;
    }

}