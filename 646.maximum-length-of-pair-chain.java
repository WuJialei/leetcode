/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start
class Solution {

    public class Pair {
        int x;
        int y;
        public Pair (int a, int b) {
            x = a;
            y = b;
        }
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; ++i) {
            p[i] = new Pair(pairs[i][0], pairs[i][1]);
        }
        Arrays.sort(
            p,
            (a, b) -> {
                if (a.y == b.y) {
                    return a.x - b.x;
                } else {
                    return a.y - b.y;
                }
            }
        );
        int[] dp = new int[n+1];
        dp[1] = 1;
        int ans = 1;
        // dp[i] = dp[j] + 1, j < i && p[j].y < p[i].x
        for (int i = 2; i <= n; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j >= 1; --j) {
                if (p[j-1].y < p[i-1].x) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
// @lc code=end

