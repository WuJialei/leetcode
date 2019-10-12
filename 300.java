import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int end = 0;
        int[] tail = new int[len]; 
        tail[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int index = Arrays.binarySearch(tail, 0, end+1, nums[i]);
                if (index < 0) {
                    index = -index - 1;
                } 
                tail[index] = nums[i];
            }
        }
        return end+1;
        /*
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i){
            int temp = 1;
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    temp = Math.max(temp, dp[j] + 1);
                }                
            }
            //System.out.println("temp: " + temp);
            dp[i] = temp;
        }
        int result = 1;
        for(int t : dp){
            result = Math.max(result, t);
        }
        return result;
        */
        /*
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        */
       
    }
}
