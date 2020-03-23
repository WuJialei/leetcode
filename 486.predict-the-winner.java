/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {

    public class Pair{
        int fir;
        int sec;
        public Pair(int a, int b) {
            fir = a;
            sec = b;
        }
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Pair[][] dp = new Pair[n][n];
        // dp[i][j]表示从第i到j个商品最大，fir表示先手，sec表示后手
        for (int i = 0; i < n; ++i) {
            dp[i][i] = new Pair(nums[i], 0);
        }
        // dp[i][j].fir = max{nums[i] + dp[i+1][j].sec, nums[j] + dp[i][j-1].sec}
        // dp[i][j].sec = dp[i+1][j].fir, 先手选左堆； dp[i][j-1].fir, 先手选右堆；
        for (int cnt = 1; cnt < n; ++cnt) {
            int j = cnt;
            for (int i = 0; i < n - cnt; ++i) {
                int left = nums[i] + dp[i+1][j].sec;
                int right = nums[j] + dp[i][j-1].sec;
                int fir = Math.max(left, right);
                int sec = left > right ? dp[i+1][j].fir : dp[i][j-1].fir;
                dp[i][j] = new Pair(fir, sec);
                ++j;
            }
        }
        return dp[0][n-1].fir >= dp[0][n-1].sec;
    }
}
// @lc code=end

