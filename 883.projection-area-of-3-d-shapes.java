/*
 * @lc app=leetcode id=883 lang=java
 *
 * [883] Projection Area of 3D Shapes
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // int[] xz = new int[m];
        // int[] yz = new int[n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            int tmp = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    ++ans;
                    tmp = Math.max(tmp, grid[i][j]);
                }
            }
            // xz[i] = tmp;
            ans += tmp;
        }
        for (int j = 0; j < n; ++j) {
            int tmp = 0;
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] > 0) {
                    tmp = Math.max(tmp, grid[i][j]);
                }
            }
            // yz[j] = tmp;
            ans += tmp;
        }
        return ans;
    }
}
// @lc code=end

