import java.util.Arrays;

/*
 * @lc app=leetcode id=1039 lang=java
 *
 * [1039] Minimum Score Triangulation of Polygon
 */

// @lc code=start
class Solution {

    int[] points;
    int[][] dp;

    public int minScoreTriangulation(int[] A) {
        points = A;
        int n = A.length;
        dp = new int[n][n];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        // dp[i][j] 表示从i到j的最小三角形乘积和
        // 记忆化优化dfs
        return dfs(0, n-1);
    }

    public int dfs (int left, int right) {
        int ans = Integer.MAX_VALUE;
        if (left + 1 == right) {
            return dp[left][right] = 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        for (int k = left + 1; k < right; ++k) {
            ans = Math.min(ans, dfs(left, k) + dfs(k, right) + points[left] * points[right] * points[k]);
        }
        return dp[left][right] = ans;
    }

}
// @lc code=end

