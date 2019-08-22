class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int temp : nums) {
        	ret = ret ^ temp;
        }
        return ret;
    }
}