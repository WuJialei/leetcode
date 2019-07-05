class NumArray {

	int[] sums;

    public NumArray(int[] nums) {
        int[] sums = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            if(i == 0){
                sums[i] = nums[i];
            }
            else{
                sums[i] = nums[i] + sums[i-1];
            }
            this.sums = sums;
        	
        }
    }
    
    public int sumRange(int i, int j) {
        return i==0 ? sums[j] : sums[j] - sums[i-1]; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */