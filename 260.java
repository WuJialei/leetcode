class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        int value = 0;
        for (int temp : nums) {
        	value ^= temp;
        }
        value &= -value;
        for (int temp : nums) {
        	if ((value & temp) == 0) {
        		ret[0] ^= temp;
        	} else {
        		ret[1] ^= temp;
        	}
        }
        return ret;
    }
}