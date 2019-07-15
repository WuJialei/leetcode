class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length - 1;
        int result = 0;
        while(begin <= end){
        	result += nums[end] - nums[begin];
        	--end;
        	++begin;
        }
        return result;
    }
}