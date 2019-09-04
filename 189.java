class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] arrays, int start, int end) {
    	while (start < end) {
    		int tmp = arrays[start];
    		arrays[start] = arrays[end];
    		arrays[end] = tmp;
    		++start;
    		--end;
    	}
    }

}