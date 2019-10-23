class Solution {
    public int missingNumber(int[] nums) {
        /*
        int ans = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            ans ^= i ^ nums[i];
        }
        return ans;
        */

        int len = nums.length;
        int sums = (1 + len) * len / 2;
        for (int temp : nums) {
            sums -= temp;
        }
        return sums;
    }
}