/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {

    int[] arrays;

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        arrays = nums;
        /*
        int a = nums[0];
        int b = 0;
        int ans = a;
        // dp[i]表示以结尾的最大连续子序和
        // dp[i] = max{dp[i-1]+nums[i], nums[i]}
        for (int i = 1; i < nums.length; ++i) {
            b = Math.max(a + nums[i], nums[i]);
            ans = Math.max(b, ans);
            a = b;
        }
        return ans;
        */
        return maxSubA(0, nums.length-1);

    }

    public int maxSubA(int left, int right) {
        if (left == right) {
            return arrays[left];
        }
        if (left > right) {
            return 0;
        }
        int mid = left + (right-left)/2;
        // 分治，左最大，右最大，含左右中间向两边扩散的最大
        return Math.max(Math.max(maxSubA(left, mid), maxSubA(mid+1, right)), maxSubM(left, mid, right));
    }

    public int maxSubM(int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int l = mid;
        int temp = 0;
        while (l >= left) {
            temp += arrays[l];
            leftSum = Math.max(leftSum, temp);
            --l;
        }
        temp = 0;
        int r = mid + 1;
        while (r <= right) {
            temp += arrays[r];
            rightSum = Math.max(rightSum, temp);
            ++r;
        }
        return leftSum + rightSum;
    }


}
// @lc code=end

